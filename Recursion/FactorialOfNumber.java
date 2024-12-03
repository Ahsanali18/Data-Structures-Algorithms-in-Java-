package RecursionPractiseQuestions;
import java.util.*;

public class FactorialOfNumber{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter any number: ");
		int n=sc.nextInt();
		
		if(n>=0) {
			int fact=1;
			for(int i=1; i<=n; i++){
			fact=fact*i;
			}
			System.out.println("Factorial of number is: "+fact);
		}
		else {
			System.out.println("Factorial of negative number is not possible");
		}
	}
}
