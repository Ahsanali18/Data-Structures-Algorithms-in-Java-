package ArrayImportantProblems;
import java.util.Arrays;

public class TwoNumberSum {
    public static void main(String[] args) {
        int[] numbers={3,2,4};
        int target=6;
        int[] ans=toNumbersSum(numbers,target);
        System.out.println("Answer is: "+ Arrays.toString(ans));
    }
    public static int[] toNumbersSum(int[] numbers, int target){
        if(numbers.length==0)
            return new int[]{-1,-2};
        for(int i=0; i<numbers.length; i++){
           for(int j=0; j<numbers.length; j++){
               if(numbers[i]+numbers[j]==target)
                   return new int[]{i,j};
           }
        }
        return new int[]{-1, -1};
    }
}
