package main;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//Entrada - leitura do arquivo
		//1ª linha (n - imput_size)
		//2ª linha (name_alg_sort)
		
		  String file_path ="";
		  Scanner sc = new Scanner(System.in);
		  System.out.println("======================================="); 
		  System.out.println("Adicione o caminho completo do arquivo:");
		  System.out.println("=======================================");
		  while(sc.hasNext()){ file_path = sc.next();break; } //sc.close();
		//Lendo grafo de arquivo
		
		String dados = "";
		///home/fabricioalmeida/eclipse-workspace/sorting-algorithm-benchmarking/in.txt
		try{    
			FileInputStream fin=new FileInputStream(file_path);    
			int i=0;
			while((i=fin.read())!=-1){    
				//System.out.print((char)i); 
				dados+= (char)i;
			}    
			fin.close();    
		}catch(Exception e){System.out.println("O caminho de arquivo é inválido!");}
		
		//----------------------------------FIM LEITURA DE ARQUIVO--------------------------------------------
		String[] splitDados = dados.split("\n");
		int input_size = Integer.parseInt(splitDados[0]);
		String algoritmo = splitDados[1];
		int[] num = Inputs.intsRandom(input_size);//Array com numeros desordenados aleatóriamente
		String name_file_out = "file_results";//nome do arquivo que gravará as saídas do algorítmos
		
		System.out.println("Tamanho da entrada: "+input_size+"\nAlgorítmo: "+ algoritmo+"");
		
		if(algoritmo.compareTo("bubble_sort")==0) {
			//BubbleSort
			System.out.print("\n--------------------------------------------------------------------------------------------------------");
			System.out.println("\nResultados ");
			long timeBSInicial = System.currentTimeMillis();//inicia o time
			int[] bubble = Algorithms.bubbleSort(num);
			long tb = runtimeFinal(timeBSInicial);//finaliza, calcula e salva o time
			long ram = getMemoriaRam();
			long ramMB = ram/(1024L * 1024L);
			System.out.println("RAM: "+ ram+ "bytes ("+ramMB+"MB)");
			saveToFile(name_file_out, algoritmo, bubble.length, "caso", tb, ram);
			
			//printa entradas pequenas, só pra  mostrar a saida ordenada, N grandes não tem necessidade
			if(bubble.length<101) {printResult(bubble);}
		}else if(algoritmo.compareTo("quick_sort")==0) {
			//QuickSort
			System.out.println("\n-------------------------------------------------------------------------------------------------------");
			System.out.println("Quick");
			long timeQSInicial = System.currentTimeMillis();//inicia o time
			int[] quick  = Algorithms.quickSort(num, num[0], num.length-1);
			runtimeFinal(timeQSInicial);//finaliza, calcula e salva o time
			
			//printa entradas pequenas, só pra  mostrar a saida ordenada, N grandes não tem necessidade
			if(quick.length<101) {printResult(quick);}
			
		}else if(algoritmo.compareTo("shell_sort")==0) {
			//ShellSort
			System.out.println("\n--------------------------------------------------------------------------------------------------------");
			System.out.println("Shell ");
			long timeSSInicial = System.currentTimeMillis();//inicia o time
			int[] shell = Algorithms.shellSort(num);
			runtimeFinal(timeSSInicial);//finaliza, calcula e salva o time
			
			//printa entradas pequenas, só pra  mostrar a saida ordenada, N grandes não tem necessidade
			if(shell.length<101) {printResult(shell);}  
			
		}
		else {System.out.println("Algorítmo não encontrado. Tente novamente!");}
		

	}
	public static long runtimeFinal(long inicio) {
		long t = System.currentTimeMillis() - inicio;
		System.out.println("Tempo de execução: "+ t + " ms");
		return t;
	}
	public static long getMemoriaRam() {
		// Get the Java runtime
        Runtime runtime = Runtime.getRuntime();
        // Calculate the used memory
        long ram_bytes = runtime.totalMemory() - runtime.freeMemory();
        long MB = 1024L * 1024L;
        long ram = ram_bytes/MB;
		return ram_bytes;
	}
	public static void saveToFile(String filename, String algoritmo, int size_n, String caso, long tempo_exec, long ram){
		Date tempo_atual = new Date();
		tempo_atual.toString();
		//long tempo_atual = t_atual.getTime();
		String file = filename+".txt";
		try {
			 
		      FileWriter escreva = new FileWriter(file,true);
		      String linha = tempo_atual+", "+algoritmo+", "+size_n+", "+caso+", "+tempo_exec+", "+ram;
		      escreva.write(linha+"\n");
		      escreva.close();
		      System.out.println("Os dados foram gravados no arquivo de saída!");
		    } catch (IOException e) {
		      System.err.println("Erro ao gravar no arquivo de saída!");
		      e.printStackTrace();
		    }
	}
	public static void printResult(int[] result) {
		for(int i = 0; i < result.length; i++)
			System.out.print(result[i] + " ");
	}

}
