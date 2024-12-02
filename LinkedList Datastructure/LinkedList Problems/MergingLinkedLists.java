package LinkedListQuestions;

class Node{
	int data;
	Node next;
	
	public Node(int data){
		this.data=data;
		this.next=null;
	}
}

public class MergingLinkedLists{
	private Node head;
	
	public MergingLinkedLists(){
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
	
	public void display2ndAnd2ndLast(){
		if(head==null){
			System.out.println("LinkedList is empty!");
			return;
		}
		
		Node temp1=head;
		Node temp2=head;
		
		System.out.print(temp1.next.data+" ");
		
		while(temp2.next.next!=null){
			temp2=temp2.next;
		}
		System.out.print(temp2.data+" ");
		
	}
	
	public static Node mergeSortedLists(MergingLinkedLists l1, MergingLinkedLists l2){
		Node temp1=l1.head;
		Node temp2=l2.head;
		
		Node head=new Node(0);
		Node t=head;
		
		while(temp1!=null && temp2!=null){
			if(temp1.data<temp2.data){
				t.next=temp1;
				t=temp1;
				temp1=temp1.next;
			}
			else {
				t.next=temp2;
				t=temp2;
				temp2=temp2.next;
			}
		}
		if(temp1==null){
			t.next=temp2;
		}
		else {
			t.next=temp1;
		}
		return head.next;
	}
	
	public static void main(String[] args) {
		MergingLinkedLists l1=new MergingLinkedLists();
		l1.insert(2);
		l1.insert(3);
		l1.insert(4);
		l1.insert(5);
		
		MergingLinkedLists l2=new MergingLinkedLists();
		l2.insert(1);
		l2.insert(6);
		l2.insert(7);
		l2.insert(8);
		
		l1.display();
		l2.display();
		
		Node result =mergeSortedLists(l1,l2);
		System.out.print("Merged List is: ");
		for(Node temp=result; temp!=null; temp=temp.next){
			System.out.print(temp.data+" ");
		}
	}

}