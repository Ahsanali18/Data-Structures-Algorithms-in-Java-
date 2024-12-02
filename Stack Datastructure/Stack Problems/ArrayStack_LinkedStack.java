package ArrayStackQuestions;
/*
public class ArrayStack_LinkedStack{
	public static void arrayStackToLinkedStack(ArrayStack_LinkedStack as, LinkedStack ls){
	ArrayStack_LinkedStack temp=new ArrayStack_LinkedStack(as.size());
		
		while(as.size()>0){
			temp.push(as.pop());
		}
		
		Node newNode=new Node(temp.pop());
		
		for(Node q=newNode; temp.size()>0; q=q){
			
		}
		
	}
}

private Object[] a;
private int size=0;

public ArrayStack_LinkedStack(int capacity) {
	a=new Object[capacity];
	
}

public boolean isEmpty() {
	return a.length==0;
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

public void display(ArrayStack_LinkedStack s) {
	int size=s.size;
	ArrayStack_LinkedStack newStack=new ArrayStack_LinkedStack(size);
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
}

public class LinkedStack{
	private static class Node{
		Object data;
		Node next;
		
		public Node(Object data) {
			this.data=data;
			this.next=null;
		}
	}
	private static class Stack{
		public Node head; //need head to change at every step of pushing element. 
		
		public void push(Object element){
			Node newNode=new Node(element);
			if(head==null) {
				head=newNode; 
				return;
			}
			newNode.next=head;
			head=newNode;
		}
		
		public Object pop(){
			if(head==null) {
				throw new IllegalStateException("Stack underflow...!");
			}
			Object temp=head.data; //Storing the top fruit into temp variable.
			head=head.next;       //changing the head from it's position.
			return temp;         // returning the temp data as a popped.
		}
		
		public Object peek() {
			if(head==null) {
				throw new IllegalStateException("Stack underflow...!");
			}
			return head.data;
		}
		
		public static void displayStack(Stack s) {
			Node temp=s.head;  // point temp to head as a dummy for displaying elements.
			if(temp==null) {
				System.out.println("Stack is Empty!");
				return;
			}
			System.out.println();
			while(temp!=null) {
				System.out.println(" | "+temp.data+" | ");
				temp=temp.next;
			}
			System.out.println(" ---------");
		}
	
	public static void main(String[] args) {
		Stack fruitsStack=new Stack();
			fruitsStack.push("Mango");
			fruitsStack.push("Lemon");
			fruitsStack.push("Apple");
			fruitsStack.push("Grape");
		
			Stack.displayStack(fruitsStack);  // displaying the currently added four fruits.
				
			Object grape=fruitsStack.pop();  // popping the last inserted fruit i.e top fruit (Grape).
	
			Object apple=fruitsStack.pop(); // popping the 2nd last inserted fruit i.e 2nd top fruit (Apple).
		
			Stack.displayStack(fruitsStack);	
		}
	}
}*/



