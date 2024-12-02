package ArrayImportantProblems;

public class GeneratingPairsFromTwoArrays{
	
	public static void generatePairs(int[] array1, int[] array2){
		for(int i=0; i<array1.length; i++){
			for(int j=0; j<array2.length; j++){
				System.out.println(array1[i]+","+array2[j]);
			}
		}
	}
	public static void main(String[] args) {
		generatePairs(new int[]{1,2,3,5}, new int[] {-1,-2,-3,-5});
		
	}
}
