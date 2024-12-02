
package arrayImplementationofStacks;

public class FruitStack implements ObjectStack{
		private Object[] a;
		private int size;
		
		public FruitStack(int capacity) {
			a=new Object[capacity];
		}
		
		public void push(Object obj) {
			if(size==a.length)
				resize();
			a[size++]=obj;
		}
		
		public Object peek() {
			if(size==0)
				throw new IllegalStateException("Stack is Empty");
			return a[size-1];
		}
		
		public Object pop() {
			if(size==0)
				throw new IllegalStateException("Stack is Empty");
			Object temp=a[--size];
			a[size]=null;
			return temp;
		}
		
		public boolean isEmpty(){
			return (size==0);  // If stack is empty return true otherwise returns false. 
		}
		
		public int size() {
			return size;
		}
		
		public void resize() {
			Object[] temp=a;
			a=new Object[2*temp.length];
			System.arraycopy(temp, 0, a, 0, size);
		}
		
		public static void main(String[] args) {
			FruitStack myFruitStack=new FruitStack(5);
			
			myFruitStack.push("Apples");
			myFruitStack.push("Kiwi");
			myFruitStack.push("Grapefruit");
			
			
			System.out.println("Size after pushing 3 elements: "+myFruitStack.size+"\n");  //3
			System.out.println("|"+myFruitStack.peek()+"|"); // peeks last inserted element i.e GrapeFruit.
//			System.out.println("|  "+myFruitStack.a[1]+"    |"); // display the element at first index i.e Kiwi.
					
			myFruitStack.push("Banana");
			myFruitStack.push("Mango");
			
			System.out.println("|  "+myFruitStack.peek()+"   |\n");
	
			System.out.println("Size after pushing 5 elements: "+myFruitStack.size);
		}
}
