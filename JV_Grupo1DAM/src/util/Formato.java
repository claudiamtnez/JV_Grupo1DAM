/**
 * Proyecto: Juego de la vida.
 * Contiene métodos estáticos para la validación de datos. 
 * @source: Formato.java 
 * @author: Noelia Lozano Lozano
 */

package util;
public class Formato {
	
	/**
	 * Método que comprueba si la contraseña es robusta. Contiene al menos:
	 * Una letra mayúscula. Una letra minúscula. Un dígito numérico.
	 * Un carácter especial de los especificados: $*-+&!?%=" Especifica tamaño mínimo de 8.
	 */
	public static boolean contraseñaRobusta(String contraseña) {
		return contraseña.matches("((?=.+[A-ZÑ])(?=.+[a-zñ])(?=.+\\d)(?=.+[$*-+&!?%=\"@])).{8,}");
	}
	
	//Método que valida correo electrónico.
	public static boolean formatoCorreoValido(String correo) {
        return correo.matches("^[\\w­\\+]+(\\.[\\w­\\+]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	}
				
	//Método que valida DNI (extranjeros y españoles).
	public static boolean nifValido(String nif) {
        return nif.matches("[X-Zx-z\\d]{1}[\\d]{7}[a-zA-Z]{1}") && letraNifValida(nif);
	}
	
	//Método que convierte NIE en NIF.
	private static String convertirNie(String nif) {

		if (nif.charAt(0) == 'X') {
			nif = nif.replaceFirst("X", "0");
		}
		if (nif.charAt(0) == 'Y') {
			nif = nif.replaceFirst("Y", "1");
		} 
		if (nif.charAt(0) == 'Z') {
			nif = nif.replaceFirst("Z", "2");
		}
		return nif;
	}	
	
	//Método que valida la letra de un DNI.
	private static boolean letraNifValida(String nif) {
		String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
		
		if (nif.charAt(0) == 'X' || nif.charAt(0) == 'Y' || nif.charAt(0) == 'Z') {
			nif = convertirNie(nif);
		}
		
		int numero = Integer.parseInt(nif.substring(0, 8));
		int indice = numero % 23;
		
		if (letras.charAt(indice) == nif.charAt(8)) {
			return true;
		} else {
			return false;
		}
	}
	
	//Método para validar nombre.
	public static boolean nombreValido(String nombre) {
		if (nombre == null) {
			return false;
		}
		
		//Admite nombres compuestos de tres sílabas (Maria del Mar)
		return nombre.matches("^[A-Z][áéíóúa-z]+[ ]?[A-Záéíóúa-z]*[ ]?[A-Záéíóúa-z]*[a-záéíúó]$");
	}
	
	//Método para validar apellidos.
	public static boolean apellidosValidos(String apellidos) {
		if (apellidos == null) {
			return false;
		}
		
		//Admite primer apellido compuesto con guión.
		return apellidos.matches("^[A-Z][áéíóúa-z]+[\\-]?[A-Záéíóúa-z]*[ ]?[A-Záéíóúa-z]*[a-záéíúó]$");
	}
	
	//Método para comprobar si una fecha en formato String es correcta.
	public static boolean fechaCorrecta(String fecha) {
		String[] s = fecha.split("-");

		int dia = Integer.parseInt(s[0]);
		int mes = Integer.parseInt(s[1]);
		int año = Integer.parseInt(s[2]);

		boolean diaCorrecto; 
		boolean mesCorrecto = mes >= 1 && mes <= 12;; 
		boolean añoCorrecto = año > 0;
		
		switch (mes) {
			case 2:
				if (esBisiesto(fecha)) {
					diaCorrecto = dia >= 1 && dia <= 29;
				} else {
					diaCorrecto = dia >= 1 && dia <= 28;
				}
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				diaCorrecto = dia >= 1 && dia <= 30;
				break;
			default:
				diaCorrecto = dia >= 1 && dia <= 31;
		}
		return diaCorrecto && mesCorrecto && añoCorrecto;
	}

	//Método privado para comprobar si el año es bisiesto
	private static boolean esBisiesto(String fecha) {
		String[] s = fecha.split("-");
		int año = Integer.parseInt(s[2]);

		return (año % 4 == 0 && año % 100 != 0 || año % 400 == 0);
	}
}