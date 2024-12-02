package ArrayImportantProblems;

import java.util.Arrays;

public class CountOccurrences{
    public int LastOccurrences(int[] array, int target){
        int lastOccurrence=-1;
        if(array.length!=0){
            for(int i=0; i<array.length; i++){
                if(array[i]==target)
                    lastOccurrence=i;
            }
        }else{
            System.out.println("Array is full!");
        }
        return lastOccurrence;
    }

    public static void main(String[] args) {
        CountOccurrences obj=new CountOccurrences();
//        int[] myArray={1,2,1,3,1,4,1,5};
        int[] myArray={};
        System.out.println("Your array is: "+Arrays.toString(myArray));
        int target=9;
        int ans= obj.LastOccurrences(myArray,target);
        System.out.println("Last Occurrences of (1) is: "+ans);
    }
}
