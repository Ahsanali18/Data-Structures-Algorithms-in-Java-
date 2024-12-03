package RecursionPractiseQuestions;
import java.util.Scanner;

public class Odds{
	
	public static void oddNumbers(int i,int n){
		if(i<=n){
			System.out.println(i);
			oddNumbers(i+2,n);
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter range: ");
		int n=sc.nextInt();
		oddNumbers(1,n);
	}
}
