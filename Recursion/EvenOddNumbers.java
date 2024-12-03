package RecursionPractiseQuestions;

public class EvenOddNumbers{
	
	public void print(int n){
		if(n<=0){
			return;
		}
		print(n-2);
		if(n%2==1){
			System.out.println(n+" : "+(n+1));
		}
	}
	public static void main(String[] args) {
		EvenOddNumbers obj=new EvenOddNumbers();
		obj.print(9);
	}
}
