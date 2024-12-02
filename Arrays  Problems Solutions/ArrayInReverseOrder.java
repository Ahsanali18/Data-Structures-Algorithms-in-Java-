package ArrayImportantProblems;
import java.util.Arrays;

public class ArrayInReverseOrder{
    public int[] makeReverse(int[] array){
        int j=0;
        int[] dummy=new int[array.length];
        for(int i=array.length-1; i>=0; i--){
            dummy[j++]=array[i];
        }
        return dummy;
    }

    public static void main(String[] args) {
        ArrayInReverseOrder obj=new ArrayInReverseOrder();
        int[] originalArray={2,4,6,8,10,12,14};
        System.out.println("Original array is: "+Arrays.toString(originalArray));
        int[] reversedArray=obj.makeReverse(originalArray);
        System.out.println("Reversed array is: "+Arrays.toString(reversedArray));
    }
}
