package ArrayImportantProblems;

import java.util.Arrays;

public class FindMaximumNumber{
    public static void main(String[] args) {
        int[] numbers={22,33,44,55,66,77,88,99};
        int answer=findMaximum(numbers);
        System.out.println("Maximum number in "+ Arrays.toString(numbers)+" is: "+answer);
    }
    public static int findMaximum(int[] array){
        int maximum=array[0];
        for(int index=0; index<array.length; index++){
            if(maximum<array[index]){
                maximum=array[index];
            }
        }
        return maximum;
    }
}