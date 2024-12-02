package SearchingAlgorithms;

public class OrderAgnosticBinarySearch{
	
	public static int orderAgnosticBS(int[] array, int targetElement){
		int start=0; 
		int end=array.length-1;
		
//		Find whether the array is sorted in ascending or descending
		
		boolean isAsc;
		if(array[start]<array[end]) {
			isAsc=true;
		}
		else {
			isAsc=false;
		}
			
		while(start<=end) {
			int mid=start+(end-start)/2;
			
			if(array[mid]==targetElement)
				return mid;
			
			//For Ascending order.
			if(isAsc) {
				if(array[mid]<targetElement)
					start=mid+1;
				else 
					end=mid-1;
			}
			else {
				if(array[mid]<targetElement)
					end=mid-1;
				else
					start=mid+1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
//		int[] myArray= {2,4,6,8,10,12,14,16};
		int[] myArray= {18,17,16,15,13,12,11,7,6,4,2};
		int target=18;
		
		int ans=orderAgnosticBS(myArray, target);
		System.out.println("Element is @t index position: "+ans);
	}

}
