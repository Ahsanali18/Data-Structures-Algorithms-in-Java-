package ArrayImportantProblems;

import java.util.Arrays;

public class TwoSumTarget{
	
	public static int[][] twoSum(int[] array, int target){
		int size=array.length;
		int newSize=size*(size-1)/2;
		int pairCount=0;
		int[][] pairs=new int[newSize][2];
		
		for(int i=0; i<size; i++){
			for(int j=i+1; j<size; j++){
				if(array[i]+array[j]==target){
					pairs[pairCount][0]=array[i];
					pairs[pairCount][1]=array[j];
					pairCount++;
				}
			}
		}
		
		int[][] result=new int[pairCount][];
		System.arraycopy(pairs, 0, result, 0, pairCount);
		return result;
	}
	
	public static void main(String[] args) {
		int[] a= {2,3,4,5,7};
		int target=7;
		int[][] ans=twoSum(a,target);
		int i=0;
		System.out.print("[");
		for(int[] item:ans){
			System.out.print(Arrays.toString(item));
		}
		System.out.println("]");
	}
}
