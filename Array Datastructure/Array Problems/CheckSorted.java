package ArrayImportantProblems;

import java.util.Arrays;

public class CheckSorted{
    public boolean isSorted(int[] array){
        boolean check=true;
        if(array.length!=0){
            for(int i=1; i<array.length; i++){
                if(array[i]<array[i-1]){
                    check=false;
                    break;
                }
            }
        }
        return check;
    }

    public static void main(String[] args) {
        CheckSorted obj=new CheckSorted();
        int[] myArray={3,3,3,3,3};
        System.out.println("Your array is: "+ Arrays.toString(myArray));
        boolean ans=obj.isSorted(myArray);
        System.out.println("is Sorted: "+ans);
    }
}
