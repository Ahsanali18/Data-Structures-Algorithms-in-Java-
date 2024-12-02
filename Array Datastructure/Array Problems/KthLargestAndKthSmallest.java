package ArrayImportantProblems;

public class KthLargestAndKthSmallest{
	
	public static int[] bubbleSort(int[] array){
		int size=array.length;
		for(int i=0; i<size; i++){
			for(int j=0; j<size-1-i; j++){
				if(array[j]>array[j+1]){
					array[j]=array[j]+array[j+1];
					array[j+1]=array[j]-array[j+1];
					array[j]=array[j]-array[j+1];
				}
			}
		}
		return array;
	}
	
	public static int[] findKthSmallestAndLargest(int[] array, int k){
		if(k==0){
			return new int[]{Integer.MIN_VALUE,Integer.MAX_VALUE};
		}
		int[] sortedArray=bubbleSort(array);
		int size=array.length;
		int smallest=sortedArray[k-1];
		int largest=sortedArray[size-k];
		
		
		return new int[] {smallest,largest};
	}
	
	public static void main(String[] args) {
		int[] a= {2,3,5,6,9,10,12,-2,-4,-6};
		int k=3;
		int[] values=findKthSmallestAndLargest(a,3);
		
		System.out.println(k+"th Smallest Element is: "+values[0]);
		System.out.println(k+"th Largest  Element is: "+values[1]);		
	}

}
