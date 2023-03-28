
public class CifradoRueda {

	public static void main(String[] args) throws Exception {
		// Your code here!
		String discoExt = "1234ABCDEFGILMNOPQRSTVXZ";
		String discoInt = "BACEGKLNPRTVZ&XYSOMQIHFD";

		String cifrado = "baa&hpmiyvsvoiylrlxckngkl";
		cifrado = cifrado.toUpperCase();

		String aux = "";
		String descifrado = "";

		for (int i = 0; i < cifrado.length(); i++){
			int numero = discoInt.indexOf(cifrado.charAt(i));

			if ( i % 10 == 0 && i != 0){
				//System.out.println("Entr5a" + i);

				for (int j = 0; j < discoExt.length(); j++){
					if(j == 0){
						aux = "" + discoExt.charAt(discoExt.length() - 2);
					}else if (j == 1){
						aux += discoExt.charAt(discoExt.length() - 1);
					}else{
						aux += discoExt.charAt(j - 2);
					}
				}
				discoExt = aux;

				//System.out.println(aux);

			}
			descifrado += discoExt.charAt(numero);
			//System.out.println(descifrado);
			descifrado = descifrado.replace("122", "walshingan");
			descifrado = descifrado.replace("124", "rey");
			descifrado = descifrado.replace("123", "felipe ii");
			//System.out.println(descifrado);
		}
		System.out.println(descifrado);
	}

}
