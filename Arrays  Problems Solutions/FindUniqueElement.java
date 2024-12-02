package ArrayImportantProblems;

public class FindUniqueElement{
	
	public static int findUnique(int[] array){
		int size=array.length;
		
		for(int i=0; i<size; i++){
			for(int j=i+1; j<size; j++){
				if(array[i]==array[j]){
					array[i]=Integer.MIN_VALUE;  // !(-1) because -1 can also exist as unique element.
					array[j]=Integer.MIN_VALUE;
				}
			}
		}
		for(int i=0; i<size; i++){
			if(array[i]!=Integer.MIN_VALUE){ //Here -1 causes problem that's why Integer.MIN_VALUE.
				return array[i];
			}
		}
		return Integer.MIN_VALUE;
	}
	
	public static void main(String[] args) {
		int[] array= {1,1,2,4,2,4,-1,5,5,7,7};
		
		int ans=findUnique(array);
		System.out.println(ans);
	}

}
