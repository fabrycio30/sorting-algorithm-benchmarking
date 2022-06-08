package main;

public class Casos {
	static String caso = ""; //pior, melhor, random (Numeros ordenadod e desordenados. simula o caso médio)

	public static int[] piorCaso() {
		//array completamente desordenado
		caso = "pior";
		return null;
	}
	public static int[] melhorCaso() {
		//array completamente ordenado
		caso = "pior";
		return null;
	}
	
	public static int[] aleatorio(int input_size) {
		//array completamente desordenado
		caso = "caso_real(random)";
		int[] n = Inputs.intsRandom(input_size);
		return n;
	}
	public void setCaso(String caso) {
		this.caso = caso;
	}
	public static String getCaso() {
		return caso;
	}
}
