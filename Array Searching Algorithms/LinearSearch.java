package SearchingAlgorithms;
public class LinearSearch{
	public static void main(String[] args){
		int[] arr= {2,4,5,6,7,8,84,35,67,99,-1};
		int targetElement=-1;
		int ans=linearSearch(arr,targetElement);
		boolean ans2=linearSearch2(arr,targetElement);
		System.out.println("Index is: "+ans);
		System.out.println("Ans is: "+ans2);
	}
	static int linearSearch(int[] arr, int target){
		if(arr.length==0){
			return -1;
		}
		for(int index=0; index<arr.length; index++) {
		//check for element at every index if it is=target
			int element=arr[index];
			if(element == target)
				return index;
		}
		return Integer.MAX_VALUE;
	}
	static boolean linearSearch2(int[] arr, int target) {
		if(arr.length==0) {
			return false;
		}
		for(int index=0; index<arr.length; index++) {
			int element=arr[index];
			if(element==target)
				return true;
		}
		return false;
	}
}
