/**
 * Proyecto: Juego de la vida.
 * Implementación de la nueva clase Contraseña según el modelo2.
 * Encapsulación y herencia básica (agregación, composición y especialización).
 * Contraseña.java
 */


//Esto es una prueba.

package modelo;

import util.*;

public class Contraseña {
	
	private String texto;

	//Constructor convencional.
	public Contraseña(String texto) {
		setTexto(texto);
	}
	
	//Constructor por defecto.
	public Contraseña() {
		this("cOntraseña&0");
	}
	
	//Constructor copia.
	public Contraseña(Contraseña c) {
		this.texto = c.texto;
	}

	public boolean equals(Contraseña c){
		String c1 = Criptografia.descifrarContraseña(texto);
		String c2 = Criptografia.descifrarContraseña(c.getTexto());
		return c1.compareTo(c2) == 0;
	}
	
	public boolean equals(String c){
		String c1 = Criptografia.descifrarContraseña(texto);
		return c1.compareTo(c) == 0;
	}
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		assert texto != null;
		assert Formato.contraseñaRobusta(texto);

		this.texto = Criptografia.cifrarContraseña(texto);
	}
	
	@Override
	public String toString() {
		return texto;
	}	
}
