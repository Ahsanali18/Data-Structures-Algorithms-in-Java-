package linkedListImplementationofStacks;

public class LinkedList_ObjectStack{
	private static class Node{
		Object data;
		Node next;
		
		public Node(Object data){
			this.data=data;
			this.next=null;
		}
	}
	
	private static class Stack{
		private Node head;
		
		public boolean isEmpty(){
			return (head==null);
		}
		
		public void push(Object element){
			Node newNode=new Node(element);
			if(isEmpty()){
				head=newNode;
				return;
			}
			newNode.next=head;
			head=newNode;
		}
		
		public Object pop(){
			if(isEmpty()){
				System.out.print("Stack underflow: ");
				return null;
			}
			Object top=head.data;
			head=head.next;
			
			return top;
		}
		
		public Object peek(){
			if(isEmpty()){
				System.out.println("Stack underflow: ");
				return Integer.MIN_VALUE;
			}
			return head.data;  // else display the data which is available at the top i.e at the head.
		}
		
		public static void display(Stack s){
			Node temp=s.head;
			System.out.println();
			
			while(temp!=null){
				System.out.println(" | "+temp.data+" | ");
				temp=temp.next;
			}
			System.out.println(" ---------- ");
		}
		
		public static void main(String[] args) {
			Stack coins=new Stack();
			
			coins.push("Coin1");
			coins.push("Coin2");
			coins.push("Coin3");
			coins.push("Coin4");
			coins.push("Coin5");
			
			display(coins);
			
			Object violet=coins.pop();
			Object orange=coins.pop();
			
			display(coins);
		}
	}
}
