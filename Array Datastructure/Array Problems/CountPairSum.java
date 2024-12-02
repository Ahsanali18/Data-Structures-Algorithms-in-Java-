package ArrayImportantProblems;

import java.util.Arrays;

public class CountPairSum{
    public int pairSum(int[] array, int targetSum){
        int pairCount=0;
        for(int i=0; i<array.length; i++){
            for(int j=i+1; j<array.length; j++){
                if((array[i]+array[j])==targetSum)
                    pairCount++;
            }
        }
        return pairCount;
    }

    public static void main(String[] args) {
        CountPairSum obj=new CountPairSum();
        int[] myArray={2,4,6,8,10};
        int target=10;
        System.out.println("Given array is: "+ Arrays.toString(myArray)+" Target element for pair count is: "+target);
        int totalPairs=obj.pairSum(myArray,target);
        System.out.println("Pairs are: "+totalPairs);
    }
}
