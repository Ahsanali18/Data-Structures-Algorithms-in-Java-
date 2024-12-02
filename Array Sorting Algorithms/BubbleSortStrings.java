package ArraySortingAlrgorithms;

public class BubbleSortStrings{
	
	public static String[] bubbleSort(String[] array){
		int size=array.length;
		
		for(int i=0; i<size; i++){
			for(int j=0; j<size-1-i; j++) {
				if(array[j].compareTo(array[j+1])<0) {
					String temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
		}
		return array;
	}
	
	public static void display(String[] a) {
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		String[] a= {"Ali","Ahmed","Saqib","Zeeshan","Raza"};
		String[] sArray=bubbleSort(a);
		display(sArray);
		
		
	}
}
