/**
 * Proyecto: Juego de la vida.
 * Implementación de la nueva clase Correo según el modelo2.
 * Encapsulación y herencia básica (agregación, composición y especialización).
 * Correo.java
 */

package modelo;

import util.Formato;

public class Correo {

	private String texto;
	
	//Constructor convencional.
	public Correo(String texto) {
		setTexto(texto);
	}
	
	//Constructor por defecto.
	public Correo() {
		this("correo@correo.com");
	}
	
	//Constructor copia.
	public Correo(Correo c) {
		this(c.texto);
	}

	//Métodos de acceso.
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		if (Formato.formatoCorreoValido(texto)) {
			this.texto = texto;
		} else {
			System.out.println("Formato de correo electrónico no válido.");
		}
	}
	
	@Override
	public String toString() {
		return "EMAIL: " + texto;
	}	
}