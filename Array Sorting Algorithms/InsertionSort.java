package sortingAlgorithmsOfArray;


import java.util.Arrays;

public class InsertionSort{
	public void insertionSort(int[] array){
		int size=array.length;
		
		for(int i=1; i<size; i++){
			int key=array[i]; //assume the first value is sorted 
			int j=i-1;
			
			while(j>=0 && array[j]>key){
				array[j+1]=array[j];  //do-shifting
				j--; //move j to j+1 to avoid -1 index
			}
			array[j+1]=key; //place key at the correct position
		}
	}
	
	public static void main(String[] args) {
		int[] array= {-22,33,-33,55,11,99};
		System.out.println("Unsorted array is: "+Arrays.toString(array));
		InsertionSort s=new InsertionSort();
		s.insertionSort(array);
		
		System.out.println("Sorted array is: "+Arrays.toString(array));
	}

}
