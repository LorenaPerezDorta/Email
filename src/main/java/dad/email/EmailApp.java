package dad.email;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class EmailApp extends Application {

	private Controller controlador;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		controlador = new Controller();
		
		Scene scene = new Scene(controlador.getView(), controlador.getView().getPrefWidth(), controlador.getView().getPrefHeight());

		Stage stage = new Stage();
		stage.setTitle("Enviar Email");
		stage.setScene(scene);
		stage.getIcons().add(new Image("email-send-icon-32x32.png"));
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
