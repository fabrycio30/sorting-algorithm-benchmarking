package main;

public class GetFormat {
	static int[] arrayOrdenado;
	static long consumoRAM;
	
	public static int[] getArrayOrdenado() {
		return arrayOrdenado;
	}
	public static long getConsumoRAM() {
		return consumoRAM;
	}
	public static void setArrayOrdenado(int[] arrayOrdenado) {
		GetFormat.arrayOrdenado = arrayOrdenado;
	}
	public static void setConsumoRAM(long consumoRAM) {
		GetFormat.consumoRAM = consumoRAM;
	}
	

}
