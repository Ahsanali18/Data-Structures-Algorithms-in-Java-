package recursiveApproach;

import java.util.Scanner;

public class RecursiveFactorial{
	public int factorial(int n){
		if(n<=1){
			return 1;
		}
		return n*factorial(n-1);
	}
	public static void main(String[] args) {
		RecursiveFactorial obj=new RecursiveFactorial();
		System.out.print("Enter number to find it's factorial: ");
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int fact=obj.factorial(num);

		System.out.println("Factorial of "+num+" is: "+fact);
	}
}
