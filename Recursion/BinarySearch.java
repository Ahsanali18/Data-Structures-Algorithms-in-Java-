package RecursionPractiseQuestions;

public class BinarySearch{
	
	public static int search(int[] array, int target, int start, int end){
		if(start>end){
			return -1;
		}
		int mid=start+(end-start)/2;
		if(array[mid]==target){
			return mid;
		}
		if(target<array[mid]){ //element is at left side
			return search(array, target, start, mid-1);
		}
		// element is at right hand side
		return search(array, target, mid+1, end);
	}
	
	public static void main(String[] args) {
		int[] myArray= {1,2,3,11,22,33,44,55,67};
		int target=67;
		
		System.out.println(search(myArray, target, 0, myArray.length-1));
	}

}
