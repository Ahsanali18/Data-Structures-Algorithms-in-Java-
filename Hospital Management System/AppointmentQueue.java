package hospitalManagementSystem;
//Patient class for storing the patient details
class Patient{
	private int patientId;
	private String patientName;
	private int patientAge;
	private String patientHistory;
	// Patient class Constructor
	public Patient(int patientId, String patientName, int patientAge, String patientHistory){
		this.patientId=patientId;
		this.patientName=patientName;
		this.patientAge=patientAge;
		this.patientHistory=patientHistory;
	}
	//setters and getters (accessor and mutators) for accessing the patients details from patient class
	public void setPatientID(int patientId){this.patientId=patientId;}
	public int  getPatientID(){ return patientId;}
	
	public void   setPatientName(String patientName){ this.patientName=patientName;}
	public String getPatientName(){ return patientName;}
	
	public void setPatientAge(int patientAge){ this.patientAge=patientAge;}
	public int  getPatientAge() {return patientAge;}
	
	public void setPatientHistory(String patientHistory){ this.patientHistory=patientHistory;}
	public String getPatientHistory(){ return patientHistory;}
	
	public String toString(){
		return "{PatientID: "+patientId+", PatientName: "+patientName+", PatientAge: "+patientAge+", PatientHistory: "+patientHistory+"}.";
	}
}
//Appointment class based on the Queue implementation on the basis of Patient age (priority)
public class AppointmentQueue{
	private static class AppointmentNode{
		private Patient patient;
		AppointmentNode next;
		
		public AppointmentNode(Patient patient){
			this.patient=patient;
			this.next=null;
		}
	}
	
	private AppointmentNode front,rear;
	
	public AppointmentQueue(){
		front=rear=null;
	}
	
	public void enqueue(Patient patient){
		AppointmentNode newNode=new AppointmentNode(patient);
		if(front==null || patient.getPatientAge()>front.patient.getPatientAge()){
			newNode.next=front;
			front=newNode;
			if(rear==null)
				rear=front;
				return;
		}
		AppointmentNode temp=front;
		while(temp.next!=null && temp.next.patient.getPatientAge()>=patient.getPatientAge()){
			temp=temp.next;
		}
		newNode.next=temp.next;
		temp.next=newNode;
		if(newNode.next==null)
			rear=newNode;
	}
	
	public Patient dequeue(){
		if(front==null){
			System.out.println("Queue is empty, no appointments to schedule.");
	        return null;
		}
		Patient patient=front.patient;
		front=front.next;
		if(front==null){
			rear=null;
		}
		return patient;
	}
	
	public void displayQueue(){
		if(front==null){
			System.out.println("No appintments in the queue.");
			return;
		}
		AppointmentNode temp=front;
		while(temp!=null){
			System.out.println(temp.patient);
			temp=temp.next;
		}
		System.out.println();
	}
}


