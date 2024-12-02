package ArrayImportantProblems;

public class FindMinimumNumber{
	public static void main(String[] args){
		int[] arr= {18, -12,-7,-3,14,20};
		System.out.println(min(arr));
	}
	public static int min(int[] arr){
		int ans=arr[0];
		for(int i=1; i<arr.length;i++) {
			if(arr[i]<ans)
				ans=arr[i];
		}
		return ans;
	}
}
