package ArrayImportantProblems;

import java.util.Arrays;

public class FrequencyOfNumber {
    public int numberFrequency(int[] array, int supposedElement){
        int size=array.length;
        int counter=0;
        if(array.length!=0){
            for(int i=0; i<size; i++){
                if(array[i]==supposedElement){
                    counter++;
                }
            }
        }else
            System.out.println("Your array is null!");
        return counter;
    }
    public static void main(String[] args){
        FrequencyOfNumber obj=new FrequencyOfNumber();
        int[] myArray={10,20,30,40,10,10,11,10,10};
        System.out.println("Your array is: "+ Arrays.toString(myArray));
        int supposedElement=10;
        int ans=obj.numberFrequency(myArray, supposedElement);
        System.out.println("Frequency of (10) in your array is: "+ans);
    }
}
