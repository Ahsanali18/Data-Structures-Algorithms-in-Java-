package ArrayImportantProblems;

public class SwappingWithoutTemp{
    public void swap(int a, int b){
        a=a+b;   // Here: a=100+(-200) = -100
        b=a-b;  // then: b=-100-(-200) = 100 (which is equals to a)
        a=a-b; // now finally: a=-100-100 =-200 (which is equals to b)
        System.out.println("After swapping");
        System.out.println("a is: "+a);
        System.out.println("b is: "+b);
    }

    public static void main(String[] args) {
        SwappingWithoutTemp obj=new SwappingWithoutTemp();
        int a=100;
        int b=-200;
        System.out.println("Before swapping");
        System.out.println("a is: "+a);
        System.out.println("b is: "+b);
        obj.swap(a,b);
    }
}
