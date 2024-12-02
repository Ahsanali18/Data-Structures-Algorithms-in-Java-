package LinkedListQuestions;

class Node{
	int data;
	Node next;
	
	public Node(int data){
		this.data=data;
		this.next=null;
	}
}

class LinkedList{
	private Node head;
	
	public LinkedList(){
		this.head=null;
	}
	
	public void insert(int element){
		Node newNode=new Node(element);
		if(head==null){
			head=newNode;
			return;
		}
		Node temp=head;
		
		while(temp.next!=null){
			temp=temp.next;
		}
		temp.next=newNode;
	}

	public void display(){
		Node temp=head;
		while(temp!=null){
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}
	
	public Node removeDuplicates(){
		Node previous=head;
		Node temp=head.next;
		
		while(temp.next!=null){
			if(previous.data==temp.data){
				previous.next=temp.next;
				temp=temp.next;
			}
			else {
				previous=temp;
				temp=temp.next;
			}
		}
		return head;
	}
	
	public Node reverse(){
		Node previous=null;
		Node current=head;
		Node agla=null;
		
		while(current!=null){
			agla=current.next;
			current.next=previous;
			previous=current;
			current=agla;
		}
		return previous;
	}
	
	public void display(Node head) {
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}
}
public class RemoveDuplicatesFromLinkedList{
	public static void main(String[] args) {
		RemoveDuplicatesFromLinkedList l1=new RemoveDuplicatesFromLinkedList();
		l1.insert(1);
		l1.insert(1);
		l1.insert(1);
		l1.insert(2);
		l1.insert(2);
		l1.insert(3);
		l1.insert(4);
		l1.insert(4);
		
		l1.display();
		
		Node newNode=l1.removeDuplicates();
		
		l1.display(newNode);
		Node reverse=l1.reverse();
		
		l1.display(reverse);	
	}
}