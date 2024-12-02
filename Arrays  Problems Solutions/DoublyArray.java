package ArrayImportantProblems;

import java.util.Arrays;

public class DoublyArray{
    private int[] array={1,3,5,7,9,11,13};
    public int[] twice(){
        System.out.println("Original array is: "+Arrays.toString(array));
        for(int i=0; i<array.length; i++){
            array[i]*=2;
        }
        return array;
    }
    public static void main(String[] args){
        DoublyArray obj=new DoublyArray();
        System.out.println("Doubled array is: "+ Arrays.toString(obj.twice()));
    }
}
