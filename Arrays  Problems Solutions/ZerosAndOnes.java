package ArrayImportantProblems;

public class ZerosAndOnes{
	public static void sortZerosAndOnes(int[] array){
		int count=0;
		for(int i=0; i<array.length; i++){
			if(array[i]==0){
				count++;
			}
		}
		for(int i=0; i<array.length; i++){
			if(i<count){
				array[i]=0;
			}else {
				array[i]=1;
			}
		}
		
		for(int i:array) {
			System.out.print(i+" ");
		}
	}
	public static void main(String[] args) {
		int[] a= {1,0,1,0,0,0,1,0};
		sortZerosAndOnes(a);
	}
}
