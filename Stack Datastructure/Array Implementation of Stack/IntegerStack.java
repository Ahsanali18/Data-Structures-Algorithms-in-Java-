package arrayImplementationofStacks;

public class IntegerStack implements Stack{
	private int[] array;
	private int size=0;
	
	public IntegerStack(int capacity) {
		array=new int[capacity];
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return (size==0);
	}
	
	public void push(int element) {
		if(size==array.length) {
			throw new IllegalStateException("Stack overflow!");
		}
		array[size++]=element;
	}
	
	public int pop() {
		if(size==0) {
			throw new IllegalStateException("Stack underflow!");
		}
		int temp=array[--size];
		array[size]=0;
		return temp;
	}
	
	public int peek() {
		if(size==0) {
			throw new IllegalStateException("Stack underflow!");
		}
		return array[size-1];
	}
	
	public int sum() {
		if(size==0) {
			throw new IllegalStateException("Stack underflow!");
		}
		int sum=0;
		int index=size-1;
		while(index>=0) {
			sum+=array[index];
			index--;
		}
		return sum;
	}
	
	public static void display(IntegerStack s) {
		int size=s.size();
		if(size==0) {
			System.out.println("Stack is Empty!");
			return;
		}
		IntegerStack tempStack=new IntegerStack(size);
		
		while(s.size()>0) {
			int element=s.pop();
			System.out.println(" | "+element+" | ");
			tempStack.push(element);
		}
		System.out.println(" ----- ");
		
		//Again pushing elements into same original Stack
		while(tempStack.size()>0) {
			s.push(tempStack.pop());
		}
	}
	
	public static void main(String[] args) {
		IntegerStack numberStack=new IntegerStack(5);
		numberStack.push(1);
		numberStack.push(2);
		numberStack.push(3);
		numberStack.push(4);
		numberStack.push(5);
		
		display(numberStack);
		System.out.println("Sum: "+numberStack.sum());
		
		// peeking the top element of stack i.e 5
		
		System.out.println("Last element: "+numberStack.peek()+"");
		
		display(numberStack);  // see after peeking the last element doesn't removes.
		
		// popping the two elements from the top of the stack
		
		int five=numberStack.pop();  // Remove 5 from stack and store in five variable.
		int four=numberStack.pop(); // Remove 4 from stack and store in four variable.
		
		display(numberStack);
	}
}
