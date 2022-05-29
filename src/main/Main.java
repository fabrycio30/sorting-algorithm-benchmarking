package main;

public class Main {

	public static void main(String[] args) {
		int[] num = Inputs.intsRandom(10);//teste com 10k 
		
		//BubbleSort
		System.out.print("Bubble: ");
		int[] bubble = Algorithms.bubbleSort(num);
		for (int i = 0; i <bubble.length; i++) {
			System.out.print(bubble[i]+" ");
		}
		
		//QuickSort
		System.out.println();
		System.out.print("Quick: ");
		int[] quick  = Algorithms.quickSort(num, 0, num.length - 1);
		for(int i = 0; i < quick.length; i++)
			System.out.print(quick[i] + " ");
		
		
		//ShellSort
		System.out.println();
		System.out.print("Shell: ");
		int[] shell = Algorithms.shellSort(num);
		for(int i = 0; i < shell.length; i++)
			System.out.print(shell[i] + " ");

	}

}
