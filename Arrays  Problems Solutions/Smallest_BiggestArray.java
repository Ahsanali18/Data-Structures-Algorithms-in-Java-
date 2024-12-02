package ArrayImportantProblems;

import java.util.Arrays;

public class Smallest_BiggestArray{
    public int[] smallAndLarge(int[] array){
        int smallest=array[0];
        int largest=array[1];
            for(int i=0; i<array.length; i++){
                if(smallest>array[i]){
                    smallest=array[i];
                }
            }
            for(int j=0; j<array.length; j++){
                if(largest<array[j]){
                    largest=array[j];
                }
            }
            return new int[]{smallest, largest};
    }

    public static void main(String[] args) {
        Smallest_BiggestArray obj=new Smallest_BiggestArray();
        int[] dummyArray={-2,4,5,6,7,8,12,14};
        System.out.println("Your array is: "+ Arrays.toString(dummyArray));
        int[] answeredArray=obj.smallAndLarge(dummyArray);
        System.out.println("Smallest and largest element from your given array is: "+Arrays.toString(answeredArray));
    }
}
