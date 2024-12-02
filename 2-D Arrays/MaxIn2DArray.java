package MultiDimensionalArrays;

public class MaxIn2DArray {
	public static void main(String[] args) {
		int[][] array= {
				{22,33,44,55},
				{34,55,67,88,99},
				{12,13,43,23,35,68}
		};
		int maximumValue=max(array);
		System.out.println("Maximum value is: "+maximumValue);
	}
	public static int max(int[][] array) {
		int max=Integer.MIN_VALUE;
		for(int row=0; row<array.length; row++) {
			for(int col=0; col<array[row].length; col++) {
				if(array[row][col]>max) {
					max=array[row][col];
				}
			}
		}
		return max;
	}
}
