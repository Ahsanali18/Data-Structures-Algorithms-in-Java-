package ArrayImportantProblems;

import java.util.Arrays;

public class KthLargestAndSmallest{
	
	public static int[] bubbleSort(int[] array){
		for(int i=0; i<array.length; i++){
			for(int j=0; j<array.length-i-1; j++){
				if(array[j]>array[j+1]) {
					array[j]=array[j]+array[j+1];
					array[j+1]=array[j]-array[j+1];
					array[j]=array[j]-array[j+1];
				}
			}
		}
		return array;
	}
	
	public static int[] kthLargest_KthSmallest(int[] array, int k){
		int[] sortedArray=bubbleSort(array);
		int size=sortedArray.length;
		int smallest=sortedArray[k-1];
		int largest=sortedArray[size-k];
		
		
		return new int[] {smallest, largest};
	}
	
	public static void main(String[] args) {
		int[] array= {3,4,5,8,7,6,1};
		System.out.println("Array: "+Arrays.toString(array));
		
		int kth=3;
		
		int[] small_large=kthLargest_KthSmallest(array,kth);
		
		System.out.println(kth+"rd smallest element in array is: "+small_large[0]);
		System.out.println(kth+"rd largest  element in array is: "+small_large[1]);
	}
}
