package ArrayImportantProblems;

import java.util.Arrays;

public class SmallestAndLargestElement{
	
	public static int[] findSmallestAndLargestElement(int[] array){
		int smallest=array[0];
		int  largest=array[0];
		
		for(int i=0; i<array.length; i++){
			if(array[i]<smallest){
				smallest=array[i];
			}
			if(array[i]>largest){
				largest=array[i];
			}
		}
		return new int[] {smallest,largest};
	}
	
	public static void main(String[] args) {
		int[] array= {2,3,4,6,7,9,12,13};
		
		int[] ans=findSmallestAndLargestElement(array);
		
		System.out.println(Arrays.toString(ans));
	}

}
