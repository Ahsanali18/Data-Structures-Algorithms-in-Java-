package stackPractiseQuestions;

import java.util.Scanner;

class LinkedStack implements Stack{
	private static class Node{
		private char data;
		private Node next;
		
		public Node(char data, Node next){
			this.data=data;
			this.next=next;
		}
	}
	private Node head;
	private int size=0;
	
	public int size(){
		return this.size;
	}
	
	public boolean isEmpty(){
		return (head==null);
	}
	
	public void push(char element){
		size++;
		head=new Node(element,head);
	}
	
	public char pop(){
		if(head==null){
			throw new IllegalStateException("Stack underflow!");
		}
		char element=head.data;
		head=head.next;
		size--;
		return element;
	}
	
	public char peek(){
		if(size==0){
			System.out.print("Stack is Empty: ");
			return ' ';
		}
		return head.data;
	}

	public  boolean checkBalancedBrackets(String str){
		LinkedStack stack=new LinkedStack();
		int length=str.length();
		
		for(int i=0; i<length; i++){
			char ch=str.charAt(i);
			if(ch=='('){
				stack.push(ch);
			}
			else{  // if ch==')'
				if(stack.size()==0){
					return false;
				}
				if(stack.peek()=='('){
					stack.pop();
				}
			}
		}
		if(stack.size()>0){
			return false;
		}
		else
			return true;
	}
}


public class BalancedBrackets{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Input: ");
		String input=sc.nextLine();
		
		LinkedStack myStack=new LinkedStack();
		
		boolean ans=myStack.checkBalancedBrackets(input);
		
		System.out.println("Brackets are Balanced/Unbalanced: "+ans);
	}
}
