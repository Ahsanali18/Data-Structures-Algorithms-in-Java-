package UnWeightedGraphImplementation;

public class Graph{
	private int size;
	private String[] vertices;
	private boolean[][] a;
	
	public Graph(String[] args){
		size=args.length;
		vertices=new String[size];
		System.arraycopy(args, 0, vertices, 0, size);
		a=new boolean[size][size];
	}

	public void add(String v1, String v2){
		int i=index(v1);
		int j=index(v2);
		
		a[i][j]=a[j][i]=true; //for undirected graph
	}
	
	public int index(String v){
		for(int i=0; i<size; i++){
			if(vertices[i].equals(v)){
				return i;
			}
		}
		return a.length;
	}
	
	public String toString(){
		if(size==0)
			return "{}";
		
		StringBuffer buf=new StringBuffer("{ "+vertex(0));
		
		for(int i=1; i<size; i++){
			buf.append(", "+vertex(i));
		}
		
		return buf+"}";
	}
	
	public String vertex(int i){
		StringBuffer buf=new StringBuffer(vertices[i]+" :");
		
		for(int j=0; j<size; j++){
			if(a[i][j]){
				buf.append(vertices[j]);
			}
		}
		return buf+"";
	}
	
	public static void main(String[] args) {
		String[] vertices= {"A","B","C","D","E","F"};
		Graph g=new Graph(vertices);
		
		g.add("A", "B");
		g.add("C", "D");
		g.add("D", "F");
		g.add("E", "F");
		g.add("F", "B");
		
		System.out.println(g);
			
		/*
		 String[] vertices={"A","B","C","D","E","F","G","H","I","J"};
		 For weighted graph
		 g.add("A","B",6);
		 g.add("A","C",4);
		 g.add("B","D",9);
		 g.add("C","F",3);
		 g.add("C","E",4);
		 g.add("E","J",2);
		 g.add("F","J",2);
		 g.add("D","G",4);
		 g.add("D","H",1);
		 g.add("E","H",2);
		 g.add("E","J",2);
		 g.add("J","H",8);
		 g.add("G","H",7);; 
		 */
	}
}
