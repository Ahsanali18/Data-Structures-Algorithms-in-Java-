package ArraySortingAlrgorithms;

import java.util.Arrays;

public class BubbleSortFlag{
	
	public static int[] bubbleSort(int[] array){
		int size=array.length;
		int flag=0;
		for(int i=0; i<size; i++){
			for(int j=0; j<size-1-i; j++){
				if(array[j]>array[j+1]){
					int temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
					flag=1;
				}
			}
			if(flag==0){
				break;
			}
		}
		return array;
	}
	
	public static void main(String[] args) {
		int[] a= {2,3,-1,4,6,9,20,15,-3,-8,-9,-10};
		int[] ans=bubbleSort(a);
		
		System.out.println(Arrays.toString(ans));
		
	}

}
