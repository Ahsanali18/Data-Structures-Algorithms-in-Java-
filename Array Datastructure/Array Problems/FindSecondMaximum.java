package ArrayImportantProblems;

public class FindSecondMaximum{
	
	public static int findSecondMaximum(int[] array){
		int firstMax=array[0];
		int secondMax=array[1];
		
		
		for(int i=0; i<array.length; i++){
			if(array[i]>firstMax){
				firstMax=array[i];
			}
		}
		
		for(int i=0; i<array.length; i++){
			if(array[i]!=firstMax){
				if(array[i]>secondMax) {
					secondMax=array[i];
				}
			}
		}
		return secondMax;
	}
	
	public static void main(String[] args) {
		int[] array= {7,7,4,5,3,2,8,9,9,10,11};
		int ans=findSecondMaximum(array);
		
		System.out.println(ans);
	}

}
