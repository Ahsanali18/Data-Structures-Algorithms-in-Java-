package ArrayImportantProblems;

public class SearchInRange {
	public static void main(String[] args) {
		int[] array= {22,33,44,55,78,89,12,33};
		int targetElement=33;
		int answer=searchInRange(array,targetElement,1,3);
		System.out.println("Ans is: "+answer);
	}
	static public int searchInRange(int[] arr, int target, int start, int end){
		if(arr.length==0) {
			return -1;
		}
		//run for loop
		for(int index=start; index<=end; index++) {
			//check for element at every index if it is=target
			int element=arr[index];
			if(element==target)
				return index;
		}
		return Integer.MAX_VALUE;
	}
}
