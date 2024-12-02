package linkedListImplementationofStacks;

public class LinkedStack{
	private static class Node{
		int data;
		Node next;
		
		public Node(int data) {
			this.data=data;
			this.next=null;
		}
	}
	
	private static class Stack{
		private Node head;
		
		public boolean isEmpty() {
			return head==null;
		}
		
		public void push(int data) {
			Node newNode=new Node(data);
			if(isEmpty()) {
				head=newNode;
				return;
			}
			newNode.next=head;
			head=newNode;
		}
		
		public int pop() {
			if(isEmpty()){
				System.out.println("Stack undeflow!");
				return Integer.MIN_VALUE;
			}
			int top=head.data;
			head=head.next;
			return top;
		}
		
		public int peek(){
			if(isEmpty()){
				return Integer.MIN_VALUE;
			}
			return head.data;
		}
		public static void display(Stack s) {
		    Node current = s.head; // Start from the head of the stack
		    
		    // Traverse the stack and print each element
		    while (current != null) {
		        System.out.println(current.data);
		        current = current.next;
		    }
		}
	}
	
	public static void main(String[] args) {
		Stack myStack=new Stack();
		myStack.push(10);
		myStack.push(20);
		myStack.push(30);
		
		Stack.display(myStack);
		
		System.out.println("Last Element: "+myStack.peek());
	}
}
