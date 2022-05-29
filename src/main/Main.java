package main;

public class Main {

	public static void main(String[] args) {
		int[] num = Inputs.intsRandom(10000);//teste com 10k 
		
		int[] bubble = Algorithms.bubbleSort(num);
		
		for (int i = 0; i <bubble.length; i++) {
			System.out.print(bubble[i]+", ");
		}

	}

}
