package RecursionPractiseQuestions;

import java.util.*;

public class NaturalNumbers{
	public void printNaturalNumbers(int n){
		if(n==1){
			System.out.println(n);
			return;
		}
		printNaturalNumbers(n-1);
		System.out.println(n);
	}
	
	public static void main(String[] args) {
		NaturalNumbers obj=new NaturalNumbers();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter range for printing Natural Numbers: ");
		int range=sc.nextInt();
		obj.printNaturalNumbers(range);
	}
}
