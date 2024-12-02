package ArrayImportantProblems;

import java.util.Arrays;

public class ArrayRotation{
	
	public static void rotation(int[] array, int k){
		k=k%10;
		int size=array.length;
		int[] ans=new int[size];
		int j=0;
		for(int i=size-k; i<size; i++){
			ans[j++]=array[i];
		}
		
		//first loop to traverse elements from (1 to n-k-1)
		for(int i=0; i<size-k; i++){
			ans[j++]=array[i];
		}
		
		for(int element:ans){
			System.out.print(element+" ");
		}
	}
	public static void main(String[] args) {
		int[] array= {1,2,3,4,5,6,7,8,9,10};
		
		rotation(array,11);
	}

}
