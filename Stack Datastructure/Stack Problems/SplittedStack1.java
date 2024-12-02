package ArrayStackQuestions;

public class SplittedStack1 implements Stack{
	private Object[] array;
	private int size=0;
	
	public SplittedStack1(int capacity){
		array=new Object[capacity];
	}
	
	public int size(){
		return this.size;
	}
	@Override
	public boolean isEmpty() {
		return (size==0);
	}
	
	public void push(Object element){
		if(size==array.length) {
			throw new IllegalStateException("Stack overflow...!");
		}
		array[size++]=element;
	}
	
	public Object pop(){
		if(size==0) {
			throw new IllegalStateException("Stack underflow...!");
		}
		Object temp=array[--size];  
		array[size]=null;   // last element is being removed 
		return temp; // Returning the last element which we store as a dummy element in temp variable.
	}
	
	public Object peek() {
		if(size==0) {
			throw new IllegalStateException("Stack underflow...!");
		}
		return array[size-1];   // returning the last element of stack i.e (top)
	}
	
	public static void display(SplittedStack1 s){
		int sizeOfTempStack=s.size; // size of previous stack.
		SplittedStack1 tempStack=new SplittedStack1(sizeOfTempStack);
		System.out.println();
		while(s.size>0) {
			Object tempElement=s.pop();
			System.out.println(" | "+tempElement+" | ");
			tempStack.push(tempElement);
		}
		System.out.println(" ---------");
		
		while(tempStack.size>0) {
			s.push(tempStack.pop());
		}
	}
	
	public static void splitStack(SplittedStack1 passedStack) {
		int size=passedStack.size();
		int mid=size/2;
		
		SplittedStack1 part1=new SplittedStack1(mid);
		SplittedStack1 part2=new SplittedStack1(size-mid);
		
		while(passedStack.size()-1>mid) {
			part1.push(passedStack.pop());
		}
		
		while(passedStack.size()>0) {
			part2.push(passedStack.pop());
		}
		
		System.out.print("  Part--1  ");
		display(part1);
		
		System.out.print("  Part--2  ");
		display(part2);
	}
	
	public static void main(String[] args) {
		SplittedStack1 bookStack1=new SplittedStack1(6);
		bookStack1.push("Book1");
		bookStack1.push("Book2");
		bookStack1.push("Book3");
		bookStack1.push("Book4");
		bookStack1.push("Book5");
		
//		bookStack1.push("Book6");causes exception b/c array capacity is fixed upto 5 it's not dynamic.	

		display(bookStack1);
		
		splitStack(bookStack1);	
	}
}
