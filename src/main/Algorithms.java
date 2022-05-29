package main;

import java.util.ArrayList;
import java.util.List;

public class Algorithms{
	//bubble sort
	static int[] bubbleSort(int[] arr) {  
		int n = arr.length;  
		int temp = 0;  
		for(int i=0; i < n; i++){  
			for(int j=1; j < (n-i); j++){  
				if(arr[j-1] > arr[j]){  
					temp = arr[j-1];  
					arr[j-1] = arr[j];  
					arr[j] = temp;  
				}  

			}
		}
		return arr;
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

	static int[] quickSort(int[] arr, int low, int high){
		if (low < high){
			int pi = partition(arr, low, high);
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
		return arr;
	}
	
	  // shellSort
    static int[] shellSort(int arr[]){
        int n = arr.length;
        for (int gap = n/2; gap > 0; gap /= 2){
            for (int i = gap; i < n; i += 1){
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];
                arr[j] = temp;
            }
        }
        return arr;
    }

}
