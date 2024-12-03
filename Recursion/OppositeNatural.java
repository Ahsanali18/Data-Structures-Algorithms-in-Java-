package RecursionPractiseQuestions;

import java.util.Scanner;

public class OppositeNatural{
	
	public void printNumbers(int n){
		if(n==1){
			System.out.println(n);
			return;
		}
		System.out.println(n);
		printNumbers(n-1);
	}
	
	public static void main(String[] args) {
		OppositeNatural obj=new OppositeNatural();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter range: ");
		int range=sc.nextInt();
		
		obj.printNumbers(range);
		
	}

}
