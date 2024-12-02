package ArrayImportantProblems;

import java.util.Arrays;

public class TripletsSum {
    public int tripletSum(int[] array, int target){
        int tripletCounter=0;
        for(int i=0; i<array.length; i++){
            for(int j=i+1; j<array.length; j++){
                for(int k=j+i; k<array.length; k++){
                    if((array[i]+array[j]+array[k])==target){
                        tripletCounter++;
                    }
                }
            }
        }
        return tripletCounter;
    }

    public static void main(String[] args) {
        TripletsSum obj=new TripletsSum();
        int[] myArray={1,4,5,6,3};
        int target=12;
        System.out.println("Your array is: "+ Arrays.toString(myArray)+" target: "+target);
        int totalTriplets=obj.tripletSum(myArray,target);
        System.out.println("Total triplets in your array having sum (12) are: "+totalTriplets);
    }
}
