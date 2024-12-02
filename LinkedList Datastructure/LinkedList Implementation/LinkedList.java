package linkedlistImplementation;

public class LinkedList{
	private class Node{
		int data;
		Node next;
	
	public Node(int data){
		this.data=data;
		this.next=null;
		}
	}
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

	public void display(Node head) {
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}
	
	public Node clone(){
		Node temp=head;
		
		Node newHead=new Node(0);
		Node dummy=newHead;
		
		while(temp!=null){
			Node newNode=new Node(temp.data);
			dummy.next=newNode;
			dummy=newNode;
			temp=temp.next;
		}
		return newHead.next;
	}
	
	public static void main(String[] args) {
		LinkedList l1=new LinkedList();
		l1.insert(1);
		l1.insert(1);
		l1.insert(1);
		l1.insert(2);
		l1.insert(2);
		l1.insert(3);
		l1.insert(4);
		l1.insert(4);
		
		l1.display();
		
		Node clonnedNode=l1.clone();
		
		l1.display(clonnedNode);
	}
}