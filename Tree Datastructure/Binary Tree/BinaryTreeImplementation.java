package binaryTreeImplementation;

class BinaryTree{
	Object root;
	BinaryTree left;
	BinaryTree right;
	
	public BinaryTree(Object root){
		this.root=root;
	}
	
	public BinaryTree(Object root, BinaryTree left, BinaryTree right){
		this.root=root;
		this.left=left;
		this.right=right;
	}
	
	public String toString(){
		StringBuffer buf=new StringBuffer("");
		
/*		//For Pre-Order Traversal <Ro><Le><Ri>
		buf.append(root);
		if(left!=null)
			buf.append(" "+left);
		if(right!=null)
			buf.append(" "+right);
		
		//For Post-Order Traversal <Le><Ri><Ro>
		if(left!=null)
			buf.append(left+" ");
		if(right!=null)
			buf.append(right+" ");
		buf.append(root);                       */                                
		
		//For In-Order Traversal <Le><Ro><Ri>
		if(left!=null)
			buf.append(left+" ");
		buf.append(root);
		if(right!=null)
			buf.append(" "+right);
		
		return buf+"";
	}
	
	//Pre-Order ==> <Ro><Le><Ri>
	public String preOrderTraversal(){
		StringBuffer buf=new StringBuffer("");
		
		buf.append(root);
		if(left!=null)
			buf.append(" "+left.preOrderTraversal());
		if(right!=null)
			buf.append(" "+right.preOrderTraversal());
		
		return buf+"";
	}
	
	//Post-Order ==> <Le><Ri><Ro>
	public String postOrderTraversal(){
		StringBuffer buf=new StringBuffer("");
		
		if(left!=null)
			buf.append(left.postOrderTraversal()+" ");
		if(right!=null)
			buf.append(right.postOrderTraversal()+" ");
		buf.append(root);
		
		return buf+"";
	}
	
	//In-Order ==> <Le><Ro><Ri>
	public String inOrderTraversal(){
		StringBuffer buf=new StringBuffer("");
		
		if(left!=null)
			buf.append(left.inOrderTraversal()+" ");
		buf.append(root);
		if(right!=null)
			buf.append(" "+right.inOrderTraversal());
		
		return buf+"";
	}
	
	
	public int height(){
		//If both left and right are null then only root have size=0.
		if(left==null && right==null) 
			return 0;
		
		if(right==null) return 1+left.height();  //If right=null then return total size from left side
		if(left==null)  return 1+right.height();//If left=null then return total size from right side	
			
		return 1+Math.max(left.height(), right.height()); //If both <R>and<L> are not null then return max height from both
	}
	
	
	public int size(){
		if(left==null && right==null)
			return 1;  //For only one node (root Node) -> ()
		
		if(right==null) return 1+left.size(); //If there is connection (edge) on left side.
		if(left==null)  return 1+right.size(); //If there is connection (edge) on right side.
		
		return 1+left.size()+right.size(); //If there is connection (edges) on both sides.
	}
	
	
	public boolean isFullTree(){
		int givenTreeSize=size();
		int givenTreeHeight=height();
		
		int sizeOfFullTree=(int) Math.pow(2, givenTreeHeight+1)-1;
		
		return (givenTreeSize==sizeOfFullTree);
	}
	
	public boolean isLeaf(){
		return (left==null && right==null);
	}
	
	public boolean contains(String Nodevalue){
		if(root==null)
			return false;
		
		if(root.equals(Nodevalue))
			return true;
		
		if(left!=null && left.contains(Nodevalue))
			return true;
		
		if(right!=null && right.contains(Nodevalue))
			return true;
		
		return false;
	}
	
	public int countLeaves() {
	    if(left== null && right == null){
	        return 1; // This node is a leaf
	    }    
	    int count=0;
	    if(left!=null){
	        count+=left.countLeaves(); // Count leaves in the left subtree
	    }
	    if(right!=null){
	        count += right.countLeaves(); // Count leaves in the right subtree
	    }
	    return count;
	}
}

public class BinaryTreeImplementation{
	public static void main(String[] args) {
		//At level-3
		BinaryTree H=new BinaryTree("H");
		BinaryTree I=new BinaryTree("I");
		BinaryTree J=new BinaryTree("J");
		BinaryTree K=new BinaryTree("K");
		
		//At level-2
		BinaryTree D=new BinaryTree("D",null,H);
		BinaryTree E=new BinaryTree("E");
		BinaryTree F=new BinaryTree("F",I,null);
		BinaryTree G=new BinaryTree("G",J,K);
		
		//At level-1
		BinaryTree B=new BinaryTree("B",D,E);
		BinaryTree C=new BinaryTree("C",F,G);
		
		//At level-0
		BinaryTree A=new BinaryTree("A",B,C);
		
		System.out.println("In-Order Traversal: "+A);
		
		System.out.println("Pre-Order Traversal: "+A.preOrderTraversal());
		
		System.out.println("Post-Order Traversal: "+A.postOrderTraversal());
		
		System.out.println("In-Order Traversal: "+A.inOrderTraversal());
		
		System.out.println("Height of given binary tree: "+A.height());
		
		System.out.println("Size of given binary tree: "+A.size());
		
		System.out.println("Is given binary tree is (full-Tree): "+A.isFullTree());
		
		
		System.out.println("A node is leaf node: "+A.isLeaf());
		System.out.println("B node is leaf node: "+B.isLeaf());
		System.out.println("C node is leaf node: "+C.isLeaf());
		System.out.println("D node is leaf node: "+D.isLeaf());
		System.out.println("F node is leaf node: "+F.isLeaf());
		System.out.println("G node is leaf node: "+G.isLeaf());
		System.out.println("H node is leaf node: "+H.isLeaf());
		System.out.println("E node is leaf node: "+E.isLeaf());
		System.out.println("I node is leaf node: "+I.isLeaf());
		System.out.println("J node is leaf node: "+J.isLeaf());
		System.out.println("K node is leaf node: "+K.isLeaf());
		
		System.out.println(A.countLeaves());
	}
	
}



