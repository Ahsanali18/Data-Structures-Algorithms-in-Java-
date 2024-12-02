package arrayImplementationofStacks;

public class ArrayStack implements ObjectStack{
	private Object[] a;
	private int size=0;
	
	public ArrayStack(int capacity) {
		a=new Object[capacity];
		
	}
	
	public int size() {
		return size;
	}
	
	public void push(Object obj) {
		if(size==a.length) {
			resize();
		}
		a[size++]=obj;
	}
	
	public boolean isEmpty(){
		return (size==0);  // If stack is empty return true otherwise returns false. 
	}
	
	public Object pop() {
		if(size==0) {
			throw new IllegalStateException("Stack underflow...");
		}
		Object temp=a[--size];
		a[size]=null;
		return temp;
	}
	
	public Object peek() {
		if(size==0) {
			throw new IllegalStateException("Stack underflow...");
		}
		return a[size-1];
	}
	
	public void resize() {
			Object temp=a;
			a=new Object[a.length*2];
			System.arraycopy(temp, 0, a, 0, size);
	}
	
	public void merge(ArrayStack s1,ArrayStack s2, ArrayStack s3){
		int size1=s1.size();
		int size2=s2.size();
		int size3=s3.size();
		
		int size4=size1+size2+size3;
		
		ArrayStack s4=new ArrayStack(size4);
		
		while(s1.size()>0) {
			s4.push(s1.pop());
		}
		while(s2.size()>0) {
			s4.push(s2.pop());
		}
		
		while(s3.size()>0) {
			s4.push(s3.pop());
		}
			
		s4.display(s4);
		
		
	}
	
	public void display(ArrayStack s) {
		int size=s.size;
		ArrayStack newStack=new ArrayStack(size);
		while(s.size>0) {
			Object dummyStack=s.pop();
			System.out.println(" | "+dummyStack+" | ");
			newStack.push(dummyStack);
		}
		System.out.println(" ----- ");
		
		while(newStack.size>0) {
			s.push(newStack.pop());
		}
	}
	
	
	public static void main(String[] args) {
//		ArrayStack fruitsStack=new ArrayStack(10);
//		fruitsStack.push("A");
//		fruitsStack.push("B");
//		fruitsStack.push("C");
//		fruitsStack.push("D");
//		fruitsStack.push("E");
//		
//		System.out.println("Stack view");
//		fruitsStack.display(fruitsStack);
//		
//		Object e=fruitsStack.pop();  //Last inserted element got popped ('E')
//		Object d=fruitsStack.pop();  //2nd last inserted element got popped ('D')
//		
//		System.out.println("Stack view after popping ("+e+","+d+") two elements.");
//		
//		fruitsStack.display(fruitsStack);
//		
//		System.out.println("Last element is being peeked ("+fruitsStack.peek()+").");
		
		ArrayStack s1=new ArrayStack(2);
		s1.push("C++");
		s1.push("Java");
		
		
		ArrayStack s2=new ArrayStack(2);
		s2.push("Math");
		s2.push("Random");
		
		ArrayStack s3=new ArrayStack(2);
		s3.push("DSA");
		s3.push("Python");	
		s3.merge(s1, s2, s3);
	}
}
