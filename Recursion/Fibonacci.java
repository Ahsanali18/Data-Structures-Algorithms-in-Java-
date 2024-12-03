package RecursionPractiseQuestions;

import java.util.Scanner;
//		Fib series --> 0,1,1,2,3,5,8,13  --> fib(n)=fib(n-1)+fib(n-2) where n>2.

public class Fibonacci{
	
	public int fibo(int n){
		if(n<2){
			return n;
		}
		return fibo(n-1)+fibo(n-2);
	}
	
	public static void main(String[] args) {
		Fibonacci obj=new Fibonacci();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter position to find fibonacci number: ");
		int pos=sc.nextInt();
		int ans=obj.fibo(pos);
		System.out.println("Fibonacci at position "+pos+" is: "+ans);
	}
}
