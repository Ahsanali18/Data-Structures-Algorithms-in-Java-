package AvlTreeImplementation;
public class AVLTree{
	private int key,height;
	private AVLTree left, right;
	public static final AVLTree NIL=new AVLTree();
	
	//Constructor for leaf nodes
	public AVLTree(){
		left=right=this;
		height=-1;
	}
	
	public AVLTree(int key){
		this.key=key;
		left=right=NIL;
	}
	
	private AVLTree(int key, AVLTree left, AVLTree right){
		this.key=key;
		this.left=left;
		this.right=right;
		height=1+Math.max(left.height, right.height);
	}
	
	public int size(){
		if(this==NIL) return 0;
		
		return 1+left.size()+right.size();
	}
	
	public String preOrderTraversal(){
		StringBuffer buf=new StringBuffer("");
		if(this==NIL) 
			return "";
		
		//<Root><Left><Right>
		buf.append(this.key);
		if(left!=null)
			buf.append(" "+left.preOrderTraversal());
		if(right!=null)
			buf.append(" "+right.postOrderTraversal());
		
		return buf+"";
	}
	
	public String postOrderTraversal(){
		StringBuffer buf=new StringBuffer("");
		if(this==NIL) 
			return "";
		//<Left><Root><Right>
		if(left!=null)
			buf.append(left.postOrderTraversal()+" ");
		buf.append(key);
		if(right!=null)
			buf.append(right.postOrderTraversal()+" ");
		
		return buf+"";
	}
	
	public String inOrderTraversal(){
		StringBuffer buf=new StringBuffer("");
		if(this==NIL)
			return "";
		
		//<Left><Root><Right>
		if(left!=null)
			buf.append(left.inOrderTraversal()+" ");
		buf.append(key);
		if(right!=null)
			buf.append(" "+right.inOrderTraversal());
		
		return buf+"";
	}
	
	public String toString(){
		if(this==NIL) return "";
		//In-Order Traversal
		return left+" "+key+" "+right;
		
		//return key+" "+left+" "+right; //pre  order traversal
		//return left+" "+right+" "+key; //post order traversal
	}
	
	public boolean add(int key){
		int oldSize=size();
		grow(key);
		
		return size()>oldSize;
	}
	
	public AVLTree grow(int key){
		if(this==NIL)
			return new AVLTree(key);
		if(key==this.key)
			return this;
		if(key<this.key)
			left=left.grow(key);
		else
			right=right.grow(key);
		
		rebalance();
		
		height=1+Math.max(left.height, right.height);
		return this;
	}
	//Understand rebalance(), rotateLeft(), rotateRight() --> By making graphs
	private void rebalance(){
		if(right.height>left.height+1){
			if(right.left.height>right.right.height){
				right.rotateRight();
			}
			rotateLeft();
		}
		
		if(left.height>right.height+1){
			if(left.right.height>left.left.height){
				left.rotateLeft();
			}
			rotateRight();
		}
	}
	
	private void rotateLeft(){
		left=new AVLTree(key,left,right.left);
		key=right.key;
		right=right.right;
	}
	
	private void rotateRight(){
		right=new AVLTree(key,left.right,right);
		key=left.key;
		left=left.left;
	}
	
	public int finMinKey(){
		if(this==NIL)
			throw new IllegalStateException("Tree is Empty!");
		if(left==NIL)
			return this.key; //Min is root key
		
		return left.finMinKey();
	}
	
	public int findMaxKey(){
		if(this==NIL)
			throw new IllegalStateException("Tree is Empty!");
		if(right==NIL)
			return this.key;
		
		return right.findMaxKey();
	}
	
	public boolean contains(int key){
		if(this==NIL)
			return false; //If tree is not exist
		
		if(key==this.key)
			return true; //Key found at root
		
		if(key<this.key){
			return left.contains(key);
		}
		else{
			return right.contains(key);
		}
	}
	
	public AVLTree remove(int key){
		if(this==NIL)
			return this;  //If tree not exists return NIL
		
		if(key<this.key){
			left=left.remove(key);  //check on the left sub-tree
		}else if(key>this.key){
			right=right.remove(key); //check on the right sub-tree
		}else{
			//Case 1: Node with only one child or no child
			if(left==NIL) return right;
			if(right==NIL) return left;
			
			//Case 2: Node with two child
			//Find the minimum in the right sub-tree to which we have to replace that key
			this.key=right.finMinKey();
			right=right.remove(this.key);
		}
		
		rebalance();
		height=1+Math.max(left.height, right.height);
		return this;
	}
	
	public int countLeaves(){
		if(this==NIL)
			return 0; //If no tree exists
		
		if(this.left==NIL && this.right==NIL)
			return 1;
		
		return left.countLeaves()+right.countLeaves();
	}
	
	public static void main(String[] args) {
		/*AVLTree A=new AVLTree(99);
		A.add(34);
		A.add(45);
		A.add(44);
		A.add(55);*/
		
		AVLTree A=new AVLTree(22);
		
		A.add(33);
		A.add(44);
		A.add(55);
		A.add(66);
		A.add(77);
		A.add(88);

		System.out.println(A);
		System.out.println("Maximum key is: "+A.findMaxKey());
		System.out.println("Minimum key is: "+A.finMinKey());
		System.out.println("Remove the (66 key): "+A.remove(66));
		System.out.println("Could Tree contains the 66: "+A.contains(66));
		System.out.println("Could Tree contains the 88: "+A.contains(88));
		
		System.out.println("Total number of leaf nodes are: "+A.countLeaves());
		
		System.out.println(A.inOrderTraversal());
		
	}
}
