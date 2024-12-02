package MultiDimensionalArrays;

public class MinIn2DArray {
	public static void main(String[] args) {
		int[][] array= {
				{22,33,43,56,67,87},
				{13,14,54,34,32},
				{12,13,19,10},
				{7,8,9,2,3,-1}
		};
		System.out.println("Minimum value is: "+min(array));
	}
	public static int min(int[][] array) {
		int min=Integer.MAX_VALUE;
		for(int row=0; row<array.length; row++) {
			for(int col=0; col<array[row].length; col++) {
				if(array[row][col]<min) {
					min=array[row][col];
				}
			}
		}
		return min;
	}
}
