
public class CifrarCesar {
	private static final String ALFABETO = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
	
	public static String cifrar(String cadena) {
		cadena = cadena.toUpperCase();
		String cifrado = "";
		// Me gustan las papas
		// Oh jxvwdp ñdv sdsdv
		for(int i = 0; i < cadena.length(); i++) {
			char letra = cadena.charAt(i);
			int posicion = ALFABETO.indexOf(letra);
		
			letra = ALFABETO.charAt((posicion + 3)%ALFABETO.length());
			cifrado += letra;
			
			
		}
		return cifrado;
	}
	public static String descifrar(String cadena) {
		cadena = cadena.toUpperCase();
		String cifrado = "";
		// Me gustan las papas
		// Oh jxvwdp ñdv sdsdv
		for(int i = 0; i < cadena.length(); i++) {
			char letra = cadena.charAt(i);
			if(letra == ' ') {
				i++;
			}else {
				int posicion = ALFABETO.indexOf(letra);
			
				letra = ALFABETO.charAt((posicion - 3)%ALFABETO.length());
				cifrado += letra;
			}
			
		}
		return cifrado;
	}

}
