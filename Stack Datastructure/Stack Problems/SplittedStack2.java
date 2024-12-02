package ArrayStackQuestions;

public class SplittedStack2 implements Stack{
    Object[] array;
    private int size;

    public SplittedStack2(int capacity) {
        array = new Object[capacity];
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

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static SplittedStack2[] splitStack(SplittedStack2 passedStack, int mid) {
        SplittedStack2 firstStack = new SplittedStack2(mid);
        SplittedStack2 secondStack = new SplittedStack2(passedStack.size() - mid);
        
        while (firstStack.size() < mid) {
            firstStack.push(passedStack.pop());
        }
        
        while (!passedStack.isEmpty()) {
            secondStack.push(passedStack.pop());
        }
        
        return new SplittedStack2[]{firstStack, secondStack};
    }

    public static void displayStack(SplittedStack2 splittedStack2) {
        SplittedStack2 tempStack = new SplittedStack2(splittedStack2.size());
        
        while (!splittedStack2.isEmpty()) {
            Object element = splittedStack2.pop();
            System.out.println("| " + element + " |");
            tempStack.push(element);
        }
        System.out.println("-----");
        
        while (!tempStack.isEmpty()){
            splittedStack2.push(tempStack.pop());
        }
    }

    public static void main(String[] args) {
        SplittedStack2 myStack = new SplittedStack2(5);
        myStack.push("A");
        myStack.push("B");
        myStack.push("C");
        myStack.push("D");
        myStack.push("E");

        displayStack(myStack);
        
        int mid = myStack.size() / 2;

        SplittedStack2[] splittedStacks = splitStack(myStack, mid);

        System.out.println("First Half Stack:");
        displayStack(splittedStacks[0]);

        System.out.println("Second Half Stack:");
        displayStack(splittedStacks[1]);
    }
}
