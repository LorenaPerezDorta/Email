package dad.email;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Model {

	private StringProperty valorSmtp = new SimpleStringProperty();
	private StringProperty valorPuerto = new SimpleStringProperty();
	private StringProperty valorRemitente = new SimpleStringProperty();
	private StringProperty valorContrasenia = new SimpleStringProperty();
	private StringProperty valorDestinatario = new SimpleStringProperty();
	private StringProperty valorAsunto = new SimpleStringProperty();
	private StringProperty valorMensaje = new SimpleStringProperty();
	
	public final StringProperty valorSmtpProperty() {
		return this.valorSmtp;
	}
	
	public final String getValorSmtp() {
		return this.valorSmtpProperty().get();
	}
	
	public final void setValorSmtp(final String valorSmtp) {
		this.valorSmtpProperty().set(valorSmtp);
	}
	
	public final StringProperty valorPuertoProperty() {
		return this.valorPuerto;
	}
	
	public final String getValorPuerto() {
		return this.valorPuertoProperty().get();
	}
	
	public final void setValorPuerto(final String valorPuerto) {
		this.valorPuertoProperty().set(valorPuerto);
	}
	
	public final StringProperty valorRemitenteProperty() {
		return this.valorRemitente;
	}
	
	public final String getValorRemitente() {
		return this.valorRemitenteProperty().get();
	}
	
	public final void setValorRemitente(final String valorRemitente) {
		this.valorRemitenteProperty().set(valorRemitente);
	}
	
	public final StringProperty valorContraseniaProperty() {
		return this.valorContrasenia;
	}
	
	public final String getValorContrasenia() {
		return this.valorContraseniaProperty().get();
	}
	
	public final void setValorContrasenia(final String valorContrasenia) {
		this.valorContraseniaProperty().set(valorContrasenia);
	}
	
	public final StringProperty valorDestinatarioProperty() {
		return this.valorDestinatario;
	}
	
	public final String getValorDestinatario() {
		return this.valorDestinatarioProperty().get();
	}
	
	public final void setValorDestinatario(final String valorDestinatario) {
		this.valorDestinatarioProperty().set(valorDestinatario);
	}
	
	public final StringProperty valorAsuntoProperty() {
		return this.valorAsunto;
	}
	
	public final String getValorAsunto() {
		return this.valorAsuntoProperty().get();
	}
	
	public final void setValorAsunto(final String valorAsunto) {
		this.valorAsuntoProperty().set(valorAsunto);
	}
	
	public final StringProperty valorMensajeProperty() {
		return this.valorMensaje;
	}
	
	public final String getValorMensaje() {
		return this.valorMensajeProperty().get();
	}
	
	public final void setValorMensaje(final String valorMensaje) {
		this.valorMensajeProperty().set(valorMensaje);
	}
}
