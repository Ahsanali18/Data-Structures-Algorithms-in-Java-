package ArraySortingAlrgorithms;


public class HeapSort{
	public void heapSort(int[] array){
		int n=array.length;
		
		for(int i=n/2-1; i>=0; i--){
			heapify(array,n,i);
		}
		
		for(int i=n-1; i>0; i--){
			//Swap the first largest element with last one
			int temp=array[0];
			array[0]=array[i];
			array[i]=temp;
			
			heapify(array,i,0);
		}
	}
	public void heapify(int[] array, int n, int i){
		int largest=i;  //Initialize root as largest
		int left=2*i+1;	//left child
		int right=2*i+2; //right child
		
		if(left<n && array[left]>array[largest]){
			largest=left;
		}
		if(right<n && array[right]>array[largest]){
			largest=right;
		}
		//If root is not largest then swap
		if(largest!=i){
			int temp=array[largest];
			array[largest]=array[i];
			array[i]=temp;
			
			heapify(array,n,largest);
		}
	}
	
	public void print(int[] array){
		for(int i=0; i<array.length; i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		HeapSort hs=new HeapSort();
		int[] array= {22,44,55,18,11,23};
		hs.print(array);
		hs.heapSort(array);
		hs.print(array);
	}
}
