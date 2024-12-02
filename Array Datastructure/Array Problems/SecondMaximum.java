package ArrayImportantProblems;

import java.util.Arrays;

public class SecondMaximum {
    public int findSecondMaximum(int[] array) {
        int maximum = array[0];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (maximum < array[i]) {
                maximum = array[i];
                index = i;
            }
        }
        int secondMaximum = array[0];
        for (int i = 0; i < array.length; i++) {
            if (i != index) {
                if (secondMaximum < array[i])
                    secondMaximum = array[i];
            }
        }
        return secondMaximum;
    }

    public static void main(String[] args) {
        SecondMaximum obj=new SecondMaximum();
//        int[] dummyArray={1,2,4,6,7,8,9,10,12,17,20,22};
        int[] dummyArray={-1,-2,-3,-4};
        System.out.println("Your array is: "+ Arrays.toString(dummyArray));
        int secondMaximumElement=obj.findSecondMaximum(dummyArray);
        System.out.println("Second maximum element in your array is: "+secondMaximumElement);
    }
}

