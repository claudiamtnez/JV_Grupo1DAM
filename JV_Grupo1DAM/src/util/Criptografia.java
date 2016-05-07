/**
 * Proyecto: Juego de la vida.
 * Contiene métodos estáticos para encriptar texto. 
 * @source: Criptogradia.java 
 * @author: Noelia Lozano Lozano
 */

package util;

public class Criptografia {
	
	private static String alfabeto = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNñÑoOpPqQrRsStTuUvVwWxXyYzZ"
			+ "<>:!\"@#$%&/()=?¿+-*0123456789 ,.áéíóú";
	
	public static String cifrarContraseña(String contraseña) {
		
		StringBuilder contraseñaCifrada = new StringBuilder();
		
		int[] claveDesplazamiento = new int[contraseña.length()];
		for (int i = 0; i < claveDesplazamiento.length; i++) {
			claveDesplazamiento[i] = (int) (Math.random()*9+1);
			contraseñaCifrada.append(claveDesplazamiento[i]);
		}
		contraseñaCifrada.append("-");
		
		for (int i = 0; i < contraseña.length(); i++) {
			int desplazamiento = claveDesplazamiento[i % contraseña.length()];
			char aEncriptar = contraseña.charAt(i);
			int posicionAEncriptar = alfabeto.indexOf(aEncriptar);
			
			if (posicionAEncriptar + desplazamiento < alfabeto.length()) {
				contraseñaCifrada.append(alfabeto.charAt(posicionAEncriptar + desplazamiento));
			
			} else {
				int posicionEncriptada = (desplazamiento) - (alfabeto.length() - posicionAEncriptar);
				contraseñaCifrada.append(alfabeto.charAt(posicionEncriptada));
			}
		}
		return contraseñaCifrada.toString();
	}
	
	public static String descifrarContraseña(String claveCifrada) {
		String parteDesplazamiento = claveCifrada.substring(0, claveCifrada.indexOf('-'));
		String parteContraseña = claveCifrada.substring((claveCifrada.indexOf('-') + 1), claveCifrada.length());
		StringBuilder contraseñaOriginal = new StringBuilder();
	
		for (int i = 0; i < parteDesplazamiento.length(); i++) {
			int desplazamiento = Integer.parseInt(parteDesplazamiento.substring(i, i + 1));
			char aDesencriptar = parteContraseña.charAt(i);
			int posicionADesencriptar = alfabeto.indexOf(aDesencriptar);
		
			if (posicionADesencriptar >= desplazamiento) {
				contraseñaOriginal.append(alfabeto.charAt(posicionADesencriptar - desplazamiento));
			} else {
				contraseñaOriginal.append(alfabeto.charAt(alfabeto.length() 
											- (desplazamiento - posicionADesencriptar)));
			}
		}
		return contraseñaOriginal.toString();
	}
}