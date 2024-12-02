package MultiDimensionalArrays;

import java.util.Arrays;

public class SearchIn2DArray{
	public static void main(String[] args) {
		int[][] arr= /*new int[][]*/ {
				{22,33,44},
				{1,2,5,67,8},
				{54,89,17,12,15},
				{11,21,23,99,37,91,94}
		};	
		int target=33;
		int[] ans=search(arr,target);
		System.out.println("Ans is: "+Arrays.toString(ans));
	}
	public  static int[] search(int[][] array,int target) {
		for(int row=0; row<array.length; row++) {
			for(int col=0; col<array[row].length; col++){
				if(array[row][col]==target) {
					return new int[]{row,col};
				}
			}
		}
		return new int[] {-1,-1};
	}
}