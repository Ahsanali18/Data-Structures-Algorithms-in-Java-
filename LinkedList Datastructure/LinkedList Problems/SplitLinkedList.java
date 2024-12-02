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
	
	public Node[] split(){
		Node temp=head;
		Node evenList=new Node(0);
		Node temp1=evenList;
		Node oddList=new Node(-1);
		Node temp2=oddList;
		
		while(temp!=null){
			if(temp.data%2==0){
				Node newNode=new Node(temp.data);
				temp1.next=newNode;
				temp1=newNode;
			}
			else {
				Node newNode=new Node(temp.data);
				temp2.next=newNode;
				temp2=newNode;
			}
			temp=temp.next;
		}
		return new Node[] {evenList.next, oddList.next};
	}
	
	public void printList(Node head) {
	    Node temp = head;
	    while (temp != null) {
	        System.out.print(temp.data + " ");
	        temp = temp.next;
	    }
	    System.out.println();  // Move to the next line after printing
	}


	public void display(){
		Node temp=head;
		while(temp!=null){
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}
}

public class SplitLinkedList{
	public static void main(String[] args) {
		SplitLinkedList l1=new SplitLinkedList();
		l1.insert(2);
		l1.insert(3);
		l1.insert(4);
		l1.insert(5);
		l1.insert(8);
		l1.insert(1);
		
		l1.display();
		
		Node[] evenOdd=l1.split();
		
		l1.printList(evenOdd[0]);
		l1.printList(evenOdd[1]);
	}
}