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
	
	public void delete(int element){
		if(head==null){
			System.out.println("Linkedlist is empty!");
		}
		if(head.data==element){
			head=head.next;
			return;
		}
		Node temp=head;
		while(temp.next!=null){
			if(temp.next.data==element){
				temp.next=temp.next.next;
				return;
			}
			temp=temp.next;
		}
	}
	
	public Node findMiddleNode() {
		Node slow=head;
		Node fast=head;
		//For odd and right middle in even
		while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
		}
		
		//for odd and left middle in even
		/*while(fast.next!=null && fast.next.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		*/
		return slow;
	}
	
	public void deleteMiddle(){
		Node slow=head;
		Node fast=head;
		//means one node is present
		if(head.next==null) {
			head=head.next;
		}
		
		//If odd number and right node in even needed
		while(fast.next.next!=null && fast.next.next.next!=null){
			slow=slow.next;
			fast=fast.next.next;
		}
		slow.next=slow.next.next;
//		return head;
		
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

public class DeleteMiddleNodeOfLinkedList{
	public static void main(String[] args) {
		LinkedList l1=new LinkedList();
		l1.insert(1);
		l1.insert(2);
		l1.insert(3);
		l1.insert(4);
		l1.insert(5);
		l1.insert(7);
		l1.insert(8);
		
		l1.display();
		
//		Node middleNode;
//		middleNode=l1.findMiddleNode();
		
//		System.out.println(middleNode.data);
		
//		l1.deleteMiddle();
		
		System.out.println(l1.findMiddleNode().data);
		
//		l1.display();		
	}
}
