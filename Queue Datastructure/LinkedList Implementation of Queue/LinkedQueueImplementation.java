package LinkedListImplementationOfQueue;

class LinkedQueue implements Queue{
		private static class Node{
		private Object data;
		private Node next;
		
		public Node(Object data){
			this.data=data;
		}
	}

	private Node head=null;
	private Node tail=null;
	private int size=0;
	
	public void add(Object element){
		Node newNode=new Node(element);
		if(size==0) {
			head=tail=newNode;
		}
		else {
			tail.next=newNode;
			tail=newNode;
		}
		size++;
	}
	
	public Object first(){
		if(size==0){
			throw new IllegalStateException("Queue is Empty!");
		}
		return head.data;
	}
	
	public Object remove(){
		if(size==0){
			throw new IllegalStateException("Queue is Empty!");
		}
		Object element=head.data;
		head=head.next;
		size--;
		return element;
	}
	
	public void display(LinkedQueue queue){
		Node temp=head;
		System.out.println("-----------------------------------------------------------------------------------------------------------------------");
		while(temp!=null){
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println("\n-----------------------------------------------------------------------------------------------------------------------");
	}
	
	public int size(){
		return size;
	}
	
	public static int monthlyPocketMoney(LinkedQueue storedPocketMoney){
		Node temp=storedPocketMoney.head;
		int sum=0;
		while(temp!=null){
			sum+=(int)temp.data;
			temp=temp.next;
		}
		
		return sum;
	}
	
	public String toString(){
		String s="[";
		
		Node temp=head;
		while(temp!=null){
			s+=temp.data;
			if(temp.next!=null) {
				s+=",";
			}
			temp=temp.next;
		}
		s+="]";
		return s;
	}
	
	public boolean equals(LinkedQueue q1, LinkedQueue q2) {
		if(q1.size()!=q2.size()) {
			return false;
		}
		for(Node p=q1.head,q=q2.head;p!=head;p=p.next,q=q.next){
			if(p.data!=q.data) {
				return false;
			}
		}
		return true;
	}
}

public class LinkedQueueImplementation{
	public static void main(String[] args) {
		LinkedQueue dailyPocketMoney=new LinkedQueue();
	
		dailyPocketMoney.add(50);
		for(int i=0; i<30; i++){
			dailyPocketMoney.add(100);
		}
	
		
		dailyPocketMoney.display(dailyPocketMoney);
		
		System.out.println("Monthly pocket-money: "+LinkedQueue.monthlyPocketMoney(dailyPocketMoney));
		
		System.out.println(dailyPocketMoney.first());
		
		System.out.println(dailyPocketMoney.toString());
		
		
		LinkedQueue lq1=new LinkedQueue();
		lq1.add("Ahsan");
		lq1.add("Raza");
		
		LinkedQueue lq2=new LinkedQueue();
		
		lq2.add("Raza");
		lq2.add("Ahsan");
		
		boolean ans= dailyPocketMoney.equals(lq1, lq2);
		System.out.println(ans);
	}
}
