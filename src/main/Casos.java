package main;

public class Casos {
	static String caso = ""; //pior, melhor, random (Numeros ordenadod e desordenados. simula o caso médio)

	public static int[] piorCaso(int n) {
		//array completamente desordenado
		int[] decrescente = new int[n];
		int indx = 0;
		for (int i = n; i>0; i--) {
			decrescente[indx] = i;
			indx++;
			
		}
		caso = "pior";
		return decrescente;
	}
	public static int[] melhorCaso(int n) {
		//array completamente ordenado
		int[] crescente = new int[n];
		for (int i = 0; i<n; i++){
			crescente[i] = i;
		}
		caso = "melhor";
		return crescente;
	}
	
	public static int[] aleatorio(int input_size) {
		//array completamente desordenado
		caso = "random";
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
