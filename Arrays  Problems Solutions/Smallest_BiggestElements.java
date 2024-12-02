package ArrayImportantProblems;

import java.util.Arrays;

public class Smallest_BiggestElements{
    public int[] smallAndBig(int[] array){
        Arrays.sort(array);
        return new int[]{array[0],array[array.length-1]};
    }

    public static void main(String[] args) {
        Smallest_BiggestArray obj=new Smallest_BiggestArray();
        int[] dummyArray={-6,-5,-4,-3,1,2,3,4,5,6};
        System.out.println("Your array is: "+Arrays.toString(dummyArray));
        int[] ans=obj.smallAndLarge(dummyArray);
        System.out.println("Smallest and larget element of your array is: "+Arrays.toString(ans));
    }
}
