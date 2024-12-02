package rpn;

interface Stack{
	public void push(Object element);
	public Object pop();
	public int size();
	public Object peek();
}

class ArrayStack implements Stack{
	private Object[] array;
	private int size=0;
	
	public ArrayStack(int capacity){
		array=new Object[capacity];
	}
	
	public int size(){
		return size;
	}
	public void push(Object element){
		if(size==array.length){
			throw new IllegalStateException("Stack overflow!");
		}
		array[size++]=element;
	}
	public Object pop(){
		if(size==0){
			throw new IllegalStateException("Stack underflow!");
		}
		Object temp=array[--size];
		array[size]=null;
		return temp;
	}
	public Object peek(){
		if(size==0){
			System.out.print("Stack is empty: ");
			return null;
		}
		return array[size-1];
	}
}

public class RPN{
	
	public RPN(String[] arguments){
		ArrayStack rpn=new ArrayStack(arguments.length);
		
		for(int i=0; i<arguments.length; i++){
			String input=arguments[i];
			
			if(isAnOperator(input)){
				double y=Double.parseDouble((String) rpn.pop());
				double x=Double.parseDouble((String) rpn.pop());
				double z=evaluate(x,y,input);
				rpn.push(" "+z);
			}
			else {
				rpn.push(input);
			}
		}
		System.out.println("Final result is: "+rpn.pop());
	}
	
	
	private boolean isAnOperator(String s){
		return (s.length()==1 && "ASMD".indexOf(s)>=0);
	}
	
	private double evaluate(double x, double y, String op){
		double z=0;
		if(op.equals("A"))
			z=x+y;
		else if(op.equals("S"))
			z=x-y;
		else if(op.equals("M"))
			z=x*y;
		else
			z=x/y;
		System.out.println(x+" "+op+" "+y+"= "+z);
		return z;
	}

	public static void main(String[] args) {
//		System.out.println("Hello, RPN is true it's Running");
		String[] rpnExpression = {"1", "3", "A", "3", "A"};
		new RPN(rpnExpression);
		
//		System.out.println("Hello, RPN is false it's not running");
	}

}
