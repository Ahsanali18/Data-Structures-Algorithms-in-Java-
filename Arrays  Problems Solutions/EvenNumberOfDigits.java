package ArrayImportantProblems;

public class EvenNumberOfDigits {
    public static void main(String[] args) {
        int[] numbers={12,345,2,6,7896};
        int ans=findNumbers(numbers);
        System.out.println("Even Digits are: "+ans);
    }
    public static int findNumbers(int[] nums){
        int count=0;
        for(int num:nums){
            if(even(num)){
                count++;
            }
        }
        return count;
    }
    public static boolean even(int num){
        int numOfDigits=digits(num);
            return numOfDigits%2==0;
    }
    public static int digits(int num){
        if(num<0){
            num*=-1;
        }
        if(num==0){
            return 1;
        }
        int count=0;
        while(num>0){
            count++;
            num=num/10;
        }
        return count;
    }
}
