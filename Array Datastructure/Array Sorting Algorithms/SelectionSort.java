package ArraySortingAlrgorithms;

import java.util.Arrays;
//Passed by reference array concept for sorting 
public class SelectionSort{
	public static void selectionSort(int[] array){
		int size=array.length;
		
		for(int i=0; i<size-1; i++){
			int minIndex=i;
			
			for(int j=i+1; j<size; j++){
				if(array[minIndex]>array[j]){
					minIndex=j;
				}
			}
			int temp=array[minIndex];
			array[minIndex]=array[i];
			array[i]=temp;
			
			//Cause issue because adding and subtracting could give 0 which can't be number in given list
//			array[minIndex]=array[minIndex]+array[i];
//			array[i]=array[minIndex]-array[i];
//			array[minIndex]=array[minIndex]-array[i];
			
		}
	}
	
	public static void printArray(int[] array){
		System.out.print("{");
		for(int i=0; i<array.length; i++){
			System.out.print(array[i]+" ");
		}
		System.out.println("};");
	}
	
	public static void main(String[] args) {
//		int[] sortedArray=selectionSort(new int[] {11,13,2,3,5,6,7,8});
//		System.out.println(Arrays.toString(sortedArray));
		
		int[] unsortedArray= {2,3,11,22,55,-9,8,5};
		System.out.print("Unsorted array is: ");
		printArray(unsortedArray);

		selectionSort(unsortedArray);
		
		System.out.print("Sorted array is: ");
		printArray(unsortedArray);
	}
}
 