package hospitalManagementSystem;
//Binary Search Tree for Age Priority
public class AgePriorityBST{
	private Patient patient;
	private AgePriorityBST left, right;
	public static final AgePriorityBST NIL=new AgePriorityBST();
	
	public AgePriorityBST(){
		patient=null;
		left=right=null;
		
	}
	//Constructor
	public AgePriorityBST(Patient patient){
		this.patient=patient;
		left=right=NIL;
	}
	//Size to check the tree size
	public int size(){
		if(this==NIL){
			return 0;
		}
		return 1+left.size()+right.size();
	}
	//toString() method to display the patients records 
	public String toString(){
		if(this==NIL)
			return "";
		return "{"+left.toString()+" "+patient+" "+right+"}.";
	}
	//Method to add the patients and grow the tree 
	public boolean add(Patient patient) {  
	    return grow(patient) != NIL; // If grow returns NIL, the insertion didn't succeed  
	}
	//Method to grow the tree after adding the patients
	public AgePriorityBST grow(Patient patient){
		if(this==NIL)
			return new AgePriorityBST(patient);
		
		if(this.patient==null){
			this.patient=patient;
			left=NIL;
			right=NIL;
			return this;
		}
		
		if(this.patient.getPatientAge()==this.patient.getPatientAge()){
			return this; //Prevent duplication of patient
		}
		if(patient.getPatientAge()<this.patient.getPatientAge()){
			left=left.grow(patient);
		}else{
			right=right.grow(patient);
		}
		
		return this;
	}
	//Method to check whether the patient present or not according to the age in the tree
	public boolean contains(int age){
		if(this==NIL)
			return false;
		
		if(this.patient.getPatientAge()==age)
			return true;
		
		if(age<this.patient.getPatientAge()){
			return left.contains(age);
		}else{
			return right.contains(age);
		}
	}
}


