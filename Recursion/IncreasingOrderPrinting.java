package RecursionPractiseQuestions;
import java.util.Scanner;

public class IncreasingOrderPrinting{
	public void print(int i, int n){
		if(i<=n){
			System.out.println(i+" ");
			print(i+1,n);
		}
	}
	
	public static void main(String[] args) {
		IncreasingOrderPrinting obj=new IncreasingOrderPrinting();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Initial Number: ");
		int initialRange=sc.nextInt();
		System.out.print("Enter final Number: ");
		int finalRange=sc.nextInt();
		
		obj.print(initialRange, finalRange);
		
	}

}
