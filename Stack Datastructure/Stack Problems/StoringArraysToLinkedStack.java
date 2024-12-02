package stackPractiseQuestions;

import java.util.Arrays;

public class StoringArraysToLinkedStack {
		private static class Node{
			int[] arrayData;
			Node next;
			
			public Node(int[] arrayData) {
				this.arrayData=arrayData;
				this.next=null;
			}
		}
		
		private static class Stack{
			public static Node head;
			
			public static boolean isEmpty() {
				return head==null;
			}
			
			public static void push(int[] array) {
				Node newNode=new Node(array);
				if(isEmpty()) {
					head=newNode;
					return;
				}
				newNode.next=head;
				head=newNode;
			}
			
			public static int[] pop() {
				if(isEmpty()) {
					System.out.println("Sorry, Your stack is Empty!");
					return null;
				}
				int[] poppedNodeData=head.arrayData;
				head=head.next;
				return poppedNodeData;
			}
			
			public static int[] peek() {
				if(isEmpty()) {
					System.out.println("Sorry, Your stack is Empty!");
					return null;
				}
				return head.arrayData;
			}
			
			public static void display(Stack s) {
				Node temp=s.head;
				
				while(temp!=null) {
					System.out.println(Arrays.toString(temp.arrayData));
					temp=temp.next;
				}
			}
		}
		
		public static void main(String[] args) {
			Stack myStack=new Stack();
			myStack.push(new int[]{2,4,6});
			myStack.push(new int[]{10,20,30});
			myStack.push(new int[]{-10,-20,-30});
			
			Stack.display(myStack);
		}
}
