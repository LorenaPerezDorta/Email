package dad.email;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Controller implements Initializable {

	private Model modelo = new Model();
	
	@FXML
	private GridPane view;
	
	@FXML
    private TextArea textMensaje;

    @FXML
    private Button botonVaciar;

    @FXML
    private Button botonCerrar;

    @FXML
    private TextField tfPuerto;

    @FXML
    private TextField tfSmtp;

    @FXML
    private TextField tfRemitente;

    @FXML
    private Button botonEnviar;

    @FXML
    private PasswordField pfContrasenia;

    @FXML
    private TextField tfDestinatario;

    @FXML
    private TextField tfAsunto;

    @FXML
    private CheckBox cbSSL;
    
    
    private Alert alerta;

	public Controller() throws IOException {
		FXMLLoader cargador = new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
		cargador.setController(this);
		cargador.load();
	}
	
	public void initialize(URL location, ResourceBundle resources) {
		
		modelo.valorSmtpProperty().bindBidirectional(tfSmtp.textProperty());
		modelo.valorPuertoProperty().bindBidirectional(tfPuerto.textProperty());
		modelo.valorRemitenteProperty().bindBidirectional(tfRemitente.textProperty());
		modelo.valorContraseniaProperty().bindBidirectional(pfContrasenia.textProperty());
		modelo.valorDestinatarioProperty().bindBidirectional(tfDestinatario.textProperty());
		modelo.valorAsuntoProperty().bindBidirectional(tfAsunto.textProperty());
		modelo.valorMensajeProperty().bindBidirectional(textMensaje.textProperty());
		
	}
	
	public Model getModelo() {
		return modelo;
	}

	public GridPane getView() {
		return view;
	}
	
	@FXML
    void cerrar(ActionEvent event) {
		Stage stage = (Stage) botonCerrar.getScene().getWindow();
	    stage.close();
    }

    @FXML
    void enviar(ActionEvent event) {

    	try
    	{
    		int puerto = Integer.parseInt(tfPuerto.textProperty().getValue());
    		
    		if(cbSSL.selectedProperty().get() == false)
    		{
    			alerta = new Alert(AlertType.WARNING);
        		alerta.setTitle("Información");
        		alerta.setHeaderText("Debe usar conexión SSL.");
        		alerta.showAndWait();
        		return;
    		}
    		else
    		{
    			Email email = new SimpleEmail();
    			email.setHostName(tfSmtp.textProperty().getValue());
    			email.setSmtpPort(puerto);
    			email.setAuthenticator(new DefaultAuthenticator(tfRemitente.textProperty().getValue(), pfContrasenia.textProperty().getValue()));
    			email.setSSLOnConnect(true);
    			email.setFrom(tfRemitente.textProperty().getValue());
    			email.setSubject(tfAsunto.textProperty().getValue());
    			email.setMsg(textMensaje.textProperty().getValue());
    			email.addTo(tfDestinatario.textProperty().getValue());
    			email.send();
    			
    			alerta = new Alert(AlertType.INFORMATION);
        		alerta.setTitle("Éxito");
        		alerta.setHeaderText("Email enviado");
        		alerta.setContentText("Email enviado con éxito a '" + tfDestinatario.textProperty().getValue() + "'");
        		alerta.showAndWait();
        		
        		modelo.setValorDestinatario("");
        		modelo.setValorAsunto("");
        		modelo.setValorMensaje("");
    		}
    	}
    	catch(EmailException e)
    	{
    		alerta = new Alert(AlertType.ERROR);
    		alerta.setTitle("Error");
    		alerta.setHeaderText("No se pudo enviar el email");
    		alerta.setContentText(e.getMessage());
    		alerta.showAndWait();
    	}
    	catch(NumberFormatException e)
    	{
    		alerta = new Alert(AlertType.ERROR);
    		alerta.setTitle("Error");
    		alerta.setHeaderText("No se pudo enviar el email");
    		alerta.setContentText("El puerto designado es incorrecto.");
    		alerta.showAndWait();
    	}
    	catch(Exception e)
    	{
    		alerta = new Alert(AlertType.ERROR);
    		alerta.setTitle("Error");
    		alerta.setHeaderText("No se pudo enviar el email");
    		alerta.setContentText("Ha ocurrido un error inesperado.");
    		alerta.showAndWait();
    	}
    }

    @FXML
    void vaciar(ActionEvent event) {

    	modelo.setValorAsunto("");
    	modelo.setValorContrasenia("");
    	modelo.setValorDestinatario("");
    	modelo.setValorMensaje("");
    	modelo.setValorPuerto("");
    	modelo.setValorRemitente("");
    	modelo.setValorSmtp("");
    	cbSSL.selectedProperty().set(false);
    }
}
