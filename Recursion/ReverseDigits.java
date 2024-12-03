package RecursionPractiseQuestions;

public class ReverseDigits{
	
	public static int reverse(int n){
		int digits=(int) Math.log10(n)+1; //Calculates the total digits in any number.
		return helper(n,digits);
	}
	
	private static int helper(int n , int digits){
		if(n%10==n){  //Because 5%10==5 always means modulo of single number is always that number.
			return n;
		}
		int rem=n%10;
		return rem* (int) Math.pow(10, digits-1)+helper(n/10,digits-1);
	}
	
	public static void main(String[] args) {
		System.out.println(reverse(4566));
		
		System.out.println((int)Math.log10(88)+1);
	}

}
