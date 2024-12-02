package multiArrayProblems;

import java.util.Arrays;

public class RowSumSortIn2D{
	
	public int getSum(int[] a){
		int sum=0; 
		
		for(int item:a){
			sum+=item;
		}
		return sum;
	}
	
	public int[][] sort2DBySum(int[][] array){
		for(int i=0; i<array.length; i++){
			for(int j=0; j<array.length-i-1; j++){
				int sum1=getSum(array[j]);
				int sum2=getSum(array[j+1]);
				
				if(sum1>sum2){
					int[] temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
		}
		return array;
	}
	public static void main(String[] args) {
		RowSumSortIn2D o=new RowSumSortIn2D();
		int[][] a= {{1,2,4},{1,1,1},{1,2,5},{3,1}};
		
		int[][] ans=o.sort2DBySum(a);
		
		System.out.println(Arrays.deepToString(ans));
		
	}
}
