package main;

import java.util.Random;

public class Inputs {
	public  static int[] intsRandom(int size) {
		int[] numeros = new int[size];
		Random num = new Random();
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = num.nextInt(1000000);
		}
		return numeros;
	}

}
