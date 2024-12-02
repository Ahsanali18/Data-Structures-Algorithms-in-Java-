package ArrayImportantProblems;
// Given an array of integers find the first repeated number in the array either return that number
// or return it's first index.


public class FindFirstRepeadtedValue {
	public static int firstRepeatedValue(int[] array){
		int size=array.length; 
		
		for(int i=0; i<size; i++){
			for(int j=i+1; j<size; j++){
				if(array[i]==array[j]) {
//					return i; // if index is required 
					return array[i];
				}
			}
		}
		return Integer.MAX_VALUE;
	}
	
	public static void main(String[] args) {
		int[] a= {1,2,3,4,5,8,7,5,8};
		
		int ans=firstRepeatedValue(a);
		System.out.println(ans);
	}
}
