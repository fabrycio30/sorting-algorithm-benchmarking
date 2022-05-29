package main;

public class Main {

	public static void main(String[] args) {
		int[] num = Inputs.intsRandom(12000);//teste com 10k 
		
		//BubbleSort
		System.out.println("\n--------------------------------------------------------------------------------------------------------");
		System.out.println("Bubble ");
		long timeBSInicial = System.currentTimeMillis();//inicia o time
		int[] bubble = Algorithms.bubbleSort(num);
		runtimeFinal(timeBSInicial);//finaliza, calcula e salva o time
		//printa entradas pequenas, só pra  mostrar a saida ordenada, N grandes não tem necessidade
		if(bubble.length<50) {printResult(bubble);}
		
		
		//QuickSort
		System.out.println("\n-------------------------------------------------------------------------------------------------------");
		System.out.println("Quick");
		long timeQSInicial = System.currentTimeMillis();//inicia o time
		int[] quick  = Algorithms.quickSort(num, num[0], num.length-1);
		runtimeFinal(timeQSInicial);//finaliza, calcula e salva o time
		
		//printa entradas pequenas, só pra  mostrar a saida ordenada, N grandes não tem necessidade
		if(quick.length<50) {printResult(quick);}
		
		
		//ShellSort
		System.out.println("\n--------------------------------------------------------------------------------------------------------");
		System.out.println("Shell ");
		long timeSSInicial = System.currentTimeMillis();//inicia o time
		int[] shell = Algorithms.shellSort(num);
		runtimeFinal(timeSSInicial);//finaliza, calcula e salva o time
		
		//printa entradas pequenas, só pra  mostrar a saida ordenada, N grandes não tem necessidade
		if(shell.length<50) {printResult(shell);}  
		

	}
	public static long runtimeFinal(long inicio) {
		long t = System.currentTimeMillis() - inicio;
		System.out.println("time: "+ t + " ms");
		return (inicio - System.currentTimeMillis());
	}
	public static void printResult(int[] result) {
		for(int i = 0; i < result.length; i++)
			System.out.print(result[i] + " ");
	}

}
