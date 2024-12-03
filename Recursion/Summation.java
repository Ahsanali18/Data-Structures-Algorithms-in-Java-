package RecursionPractiseQuestions;

public class Summation{
	public int sum(int i, int n, int sum){
		if(i<=n){
			sum=sum+i;
			sum=sum(i+1, n, sum);
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Summation obj=new Summation();
		int totalSum=obj.sum(1, 10, 0);
		
		System.out.println("Sum: "+totalSum);
	}

}
