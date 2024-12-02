package ArrayStackQuestions;

public class PeekLastElement{
	
	private static class Stack {
    Object[] array;
    private int size;

    public Stack(int capacity) {
        array = new Object[capacity];
    }
    
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return (size == 0);   // If size=0 return true else returns false.
    }

    public void push(Object obj) {
        if (size == array.length) {
            System.out.println("Sorry, Your Stack is full!");
            return;
        }
        array[size++] = obj;
    }

    public Object pop() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty!");
        }
        Object temp = array[--size];
        array[size] = null;
        return temp;
    }

    public Object peek() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty!");
        }
        return array[size - 1];
    }

    public static void displayStack(Stack stack) {
        Stack tempStack = new Stack(stack.size());
        
        while (stack.size()>0) {
            Object element = stack.pop();
            System.out.println("| " + element + " |");
            tempStack.push(element);
        }
        System.out.println("-----");
        
        // Again re-storing the elments into original stack.
        while(tempStack.size()>0) {
        	stack.push(tempStack.pop());
        }
    }
    
    public static void peekLastElement(Stack passedStack) {
    	Stack tempStack=new Stack(passedStack.size);
    	
    	while(passedStack.size()>0) {
    		tempStack.push(passedStack.pop());
    	}
    		System.out.println("Last Element: "+tempStack.peek());
        
    	while(tempStack.size()>0){
               passedStack.push(tempStack.pop());
        	}
    	}
	}
	
    public static void main(String[] args) {
        Stack myStack = new Stack(5);
        myStack.push("A");
        myStack.push("B");
        myStack.push("C");
        myStack.push("D");
        myStack.push("E");

        Stack.displayStack(myStack);
        
        Stack.peekLastElement(myStack);
   }
}
	
