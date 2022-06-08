package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Algorithms{
	//bubble sort
	static GetFormat bubbleSort(int[] arr) {  
		GetFormat gf = new GetFormat();//retorna um objeto contendo array ordenado e o valor médio de RAM
		long ram;
		int n = arr.length;  
		int temp = 0;  
		Random r1 = new Random();
		int p1 = r1.nextInt(arr.length);
		Random r2 = new Random();
		int p2 = r2.nextInt(arr.length);
		
		
		List<Long> rams = new ArrayList<Long>();
		
		for(int i=0; i < n; i++){  
			if(p1==i || p2==i) {rams.add(DadosRam.getMemoriaRam());}
			for(int j=1; j < (n-i); j++){  
				if(arr[j-1] > arr[j]){  
					temp = arr[j-1];  
					arr[j-1] = arr[j];  
					arr[j] = temp;  
				}
				

			}
		}
		long mediaRam = (rams.get(0)+rams.get(1))/2;//pega dois pontos aleatórios e capitura o cinsumo de RAM nesses pontos (o resultado é a média)
		gf.setArrayOrdenado(arr);
		gf.setConsumoRAM(mediaRam);
		return gf;
	}


	
	// quick Sort
	static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		}

	static int partition(int[] arr, int low, int high){
		int pivot = arr[high];

		int i = (low - 1);
		for(int j = low; j <= high - 1; j++){
			if (arr[j] < pivot){
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return (i + 1);
	}

	static GetFormat quickSort(int[] arr, int low, int high){
		//inicio captura ram
		List<Long> rams = new ArrayList<Long>();
		//fim 
		if (low < high){
			int pi = partition(arr, low, high);
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
		//
		if(low >high) {rams.add(DadosRam.getMemoriaRam());}
		
		GetFormat gf = new GetFormat();
		gf.setConsumoRAM(rams.get(0));
		gf.setArrayOrdenado(arr);
		return gf;
	}
	
	  // shellSort
    static GetFormat shellSort(int arr[]){
    	//
    	Random r1 = new Random(); int p1 = 0; r1.nextInt(10);
		//Random r2 = new Random(); int p2 = r2.nextInt(arr.length/10);
		List<Long> rams = new ArrayList<Long>();
    	//
        int n = arr.length;
        for (int gap = n/2; gap > 0; gap /= 2){
        	if(gap==1) {rams.add(DadosRam.getMemoriaRam());}
            for (int i = gap; i < n; i += 1){
            	
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];
                arr[j] = temp;
            }
        }
        GetFormat gf = new GetFormat();
		gf.setConsumoRAM(rams.get(0));
		gf.setArrayOrdenado(arr);
		return gf;
    }

}
