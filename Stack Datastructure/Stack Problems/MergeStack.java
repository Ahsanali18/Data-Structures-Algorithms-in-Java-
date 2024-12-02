package ArrayStackQuestions;


class BookStack implements Stack{
	private Object[] a;
	private int size;
	
	public BookStack(int capacity){
		a=new Object[capacity];
	}
	
	public int size(){
		return size;
	}

	public boolean isEmpty(){
		return (size==0);
	}
	
	public void resize(){
		Object temp=a;
		a=new Object[a.length*2];
		System.arraycopy(temp, 0, a, 0, size);
	}
	
	public void push(Object obj) {
		if(size==a.length) {
			resize();
		}
		a[size++]=obj;
	}

	public Object pop(){
		if(size==0){
			throw new IllegalStateException("Stack underflow!");
		}
		Object poppedElement=a[--size];
		a[size]=null;
		return poppedElement;	
	}
	
	public Object peek(){
		if(size==0){
			System.out.print("Stack is Empty: ");
			return null;
		}
		return a[size-1];
	}
	
	public static void display(BookStack s){
		if(s.size()==0) {
			System.out.println("Stack is Empty!");
			return;
		}
		int tempStackSize=s.size();
		BookStack tempStack=new BookStack(tempStackSize);
		
		System.out.println();
		while(s.size()>0){
			Object element=s.pop();
			System.out.println(" | "+element+" | ");
			tempStack.push(element);
		}
		System.out.println(" ---------  ");
		
		//Again re-storing the same elements in same stack from temporary stack.
		while(tempStack.size()>0){
			s.push(tempStack.pop());
		}
		
	}
	
	public static BookStack mergeStacks(BookStack s1, BookStack s2){
		int size=s1.size()+s2.size();
		BookStack mergedStack=new BookStack(size);
		
		while(s1.size()>0){
			mergedStack.push(s1.pop());
		}
		
		while(s2.size()>0){
			mergedStack.push(s2.pop());
		}
		
		return mergedStack;
	}
}

public class MergeStack{
	
	public static void main(String[] args) {
		BookStack s1=new BookStack(3);
		s1.push("Book1");
		s1.push("Book2");
		s1.push("Book3");
		
		BookStack.display(s1);
		
		BookStack s2=new BookStack(2);
		s2.push("Book4");
		s2.push("Book5");
		s2.push("Book6");
		
		BookStack.display(s2);
		
		BookStack mergedStack=BookStack.mergeStacks(s1, s2);

		BookStack.display(mergedStack);
		
	}
}


