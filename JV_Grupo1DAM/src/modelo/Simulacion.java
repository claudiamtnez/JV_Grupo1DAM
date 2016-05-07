/**
 * Proyecto: Juego de la vida.
 * Implementa el concepto de simulación según el modelo2.1.
 * @source: Simulacion.java 
 * @author: Grupo 1 DAM
 */

package modelo;

import java.io.Serializable;
import util.Fecha;

public class Simulacion implements Serializable {
	
	private Usuario usr;
	private Fecha fecha;
	private Mundo mundo;
	private EstadoSimulacion estado;
	
	//Constructor convencional.
	public Simulacion(Usuario usr, Fecha fecha) {
		this.usr = usr;
		this.fecha = fecha;		
	}
	
	//Métodos de acceso.	
	public Usuario getUsr() {
		return usr;
	}

	public Fecha getFecha() {
		return fecha;
	}

	public EstadoSimulacion getEstado() {
		return estado;
	}

	public enum EstadoSimulacion {
		PREPARADA, INICIADA, COMPLETADA;
			
		public String toString() {
			String r = "";
			switch(this){
			case PREPARADA:
				r = "Invitado";
				break;
			case INICIADA:
				r = "Normal";
				break;
			case COMPLETADA:
				r = "Administrador";
				break;
			}
			return r;
		}
	}
}