package hospitalManagementSystem;
import java.util.ArrayList;
import java.util.Scanner;
//Main class HospitalManagementSystem for Hospital Operations
public class HospitalManagementSystem{
	private CustomHashMap patientsRecords;
	private AppointmentQueue appointments;
	private AgePriorityBST agePriorityTree;
	private ArrayList<Patient> scheduledAppointments;
	public HospitalManagementSystem(int capacity){
		patientsRecords=new CustomHashMap(capacity);
		appointments=new  AppointmentQueue();
		agePriorityTree=new AgePriorityBST();
		scheduledAppointments=new ArrayList<>();
	}
	//Add Patient method to add the patients with the necessary details in to the Hash
	public void addNewPatient(int patientID, String patientName,int patientAge, String history){
		Patient patient=new Patient(patientID,patientName,patientAge,history);
		patientsRecords.addPatient(patientID, patient);
		appointments.enqueue(patient);
		agePriorityTree.add(patient);
	}
	//Schedule appointments to schedule the appointments for the patients
	public void scheduleAppointments(){
		Patient patient=appointments.dequeue();
		if(patient!=null){
			scheduledAppointments.add(patient);
			System.out.println("Appointments scheduled for: "+patient);	
		}
		else
			System.out.println("No any Appointments scheduled.");
	}
	//Find patient history to check the history of the patient admittted in the hospital
	public void findPatientHistory(int patientID){
		Patient patient=patientsRecords.getPatient(patientID);
		if(patient!=null){
			System.out.println("Patient History-> { "+patient.getPatientHistory()+" }");
		}else{
			System.out.println("Patietn didn't any appointment");
		}
	}
	//Display the current appointments 
	public void displayAppointments(){
		System.out.println("-----------------------------------------------------------------------------------------------------------");
		System.out.println("Current Appointments Waiting (In Queue)");
		appointments.displayQueue();
		System.out.println("Scheduled Appointments");
		if(scheduledAppointments.isEmpty()){
			System.out.println("No scheduled Appointments yet!");
		}else{
			for(Patient patient:scheduledAppointments){
				System.out.println(patient);
			}
		}
		System.out.println("--------------------------------------------------------------------------------");
	}
	//Display the records of the patients 
	public void displayRecords(){
		System.out.println("Patient Records");
		patientsRecords.displayPatientsRecords();
	}
	//Discharge method to discharge the patient from the hospital
	public void dischargePatient(int patientID){
		if(patientsRecords.remove(patientID)){
			System.out.println("Patient with ID: "+patientID+" discharged!");
		}else{
			System.out.println("Patient with ID: "+patientID+" not at our hospital!");
		}
	}
	
	public static void main(String[] args) {
		HospitalManagementSystem aghaKhanHospital=new HospitalManagementSystem(100);
		System.out.println("\t\t=================== Welcome to Agha Khan Hospital ============================");
		Scanner scanner=new Scanner(System.in);
		int userChoice;
        do {
            System.out.println("\t\tChoose you choice ");
            System.out.println("\t\t1. Add New Patient");
            System.out.println("\t\t2. Schedule Appointment");
            System.out.println("\t\t3. View Appointments");
            System.out.println("\t\t4. Find Patient History");
            System.out.println("\t\t5. Remove Patient");
            System.out.println("\t\t6. Display Patient Records");
            System.out.println("\t\t0. Exit");
            System.out.print("Enter your choice: ");
            userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice) {
                case 1:
                    System.out.print("Enter Patient ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Patient Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Patient Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Patient History: ");
                    String history = scanner.nextLine();
                    aghaKhanHospital.addNewPatient(id, name, age, history);
                    System.out.println("Patient added successfully!");
                    break;
                case 2:
                    aghaKhanHospital.scheduleAppointments();
                    break;
                case 3:
                    aghaKhanHospital.displayAppointments();
                    break;
                case 4:
                    System.out.print("Enter Patient ID to find history: ");
                    int patientId = scanner.nextInt();
                    aghaKhanHospital.findPatientHistory(patientId);
                    break;

                case 5:
                    System.out.print("Enter Patient ID to Discharge the patient: ");
                    int removeId = scanner.nextInt();
                    aghaKhanHospital.dischargePatient(removeId);
                    break;

                case 6:
                    aghaKhanHospital.displayRecords();
                    break;
                case 0:
                    System.out.println("Exiting... Thank you for using Agha Khan Hospital Management System!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (userChoice != 0);
	}
}
