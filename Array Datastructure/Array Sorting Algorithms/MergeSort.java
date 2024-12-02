package ArraySortingAlrgorithms;


import java.util.Arrays;

public class MergeSort{
	public void mergeSort(int[] array, int left, int right){
		if(left<right){
			int mid=left+(right-left)/2;
			
			mergeSort(array,left,mid);
			mergeSort(array,mid+1,right);
			merge(array,left,mid,right);
		}
	}
	public void merge(int[] array, int left, int mid, int right){
		int n1=mid+1-left;
		int n2=right-mid;
		
		int[] leftArray=new int[n1];
		int[] rightArray=new int[n2];
		
		for(int i=0; i<n1; i++){
			leftArray[i]=array[left+i];
		}
		
		for(int j=0; j<n2; j++){
			rightArray[j]=array[mid+1+j];
		}
		
		int i=0;
		int j=0;
		int k=left;
		
		while(i<n1 && j<n2){
			if(leftArray[i]<=rightArray[j]){
				array[k]=leftArray[i];
				i++;
			}
			else{
				array[k]=rightArray[j];
				j++;
			}
			k++;
		}
		//Copy the remaining elements 
		while(i<n1){
			array[k]=leftArray[i];
			i++;
			k++;
		}
		while(j<n2){
			array[k]=rightArray[j];
			j++;
			k++;
		}
	}
	public static void main(String[] args) {
		int[] array= {2,4,5,6,-10,23,13,45,7};
		MergeSort s=new MergeSort();
		System.out.println("Unsorted array: "+Arrays.toString(array));
		s.mergeSort(array, 0, array.length-1);
		
		System.out.println("Sorted array:   "+Arrays.toString(array));
	}
}
