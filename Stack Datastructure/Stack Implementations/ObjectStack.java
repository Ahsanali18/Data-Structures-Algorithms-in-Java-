package arrayImplementationofStacks;

public interface ObjectStack{
	public void push(Object element);
	public Object pop();
	public Object peek();
	
	public int size();
	public boolean isEmpty();
}
