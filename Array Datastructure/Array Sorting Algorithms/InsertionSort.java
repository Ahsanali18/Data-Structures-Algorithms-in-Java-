package ArraySortingAlrgorithms;

public class InsertionSort{
	
	public static int[] insertion(int[] array){
		int key, j;
		for(int i=1; i<array.length; i++){
			key=array[i];
			j=i-1;
			
			while(j>=0 && array[j]>key){
				array[j+1]=array[j];
				j--;
			}
			array[j+1]=key;
		}
		return array;
	}
	
	public static void main(String[] args) {
		int[] a= {-4,-5,-6,7,9,11,14,19,0};
		
		int[] sortedArray=insertion(a);
		
		for(int item:sortedArray){
			System.out.print(item+" ");
		}
	}

}
