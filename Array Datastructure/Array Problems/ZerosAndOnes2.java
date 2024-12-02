package ArrayImportantProblems;

public class ZerosAndOnes2{
	
	public static void sortZerosAndOnes(int[] array){
		int size=array.length;
		int start=0;
		int end=size-1;
		
		while(start<end){
			if(array[start]==1 && array[end]==0){
				int temp=array[start];
				array[start]=array[end];
				array[end]=temp;
				start++;
				end--;
			}
			if(array[start]==0) {
				start++;
			}
			if(array[end]==1){
				end--;
			}
		}
		
		for(int element:array){
			System.out.print(element+" ");
		}
	}
	public static void main(String[] args) {
		int[] a= {0,0,1,1,1,0,1,0,0,1,1,1};
		sortZerosAndOnes(a);
	}
}
