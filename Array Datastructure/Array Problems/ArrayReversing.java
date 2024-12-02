package ArrayImportantProblems;

import java.util.Arrays;

public class ArrayReversing{
    private int[] originalArray={1,2,3,4,5,6,7,8};
    public int[] reverse(){
        System.out.println("Your Origial array is: "+Arrays.toString(originalArray));
        int left=0;
        int right=originalArray.length-1;
        while(left<right){
            int temp=originalArray[left];
            originalArray[left]=originalArray[right];
            originalArray[right]=temp;
            left++;
            right--;
        }
        return originalArray;
    }
    public static void main(String[] args) {
        ArrayReversing obj=new ArrayReversing();
        int[] reversedArray=obj.reverse();
        System.out.println("Reversed Array is: "+ Arrays.toString(reversedArray));
    }
}
