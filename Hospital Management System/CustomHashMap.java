package hospitalManagementSystem;

import java.util.LinkedList;
//Hashmap class for easy lookup for patients
public class CustomHashMap{
	private class Entity{
		int key;
		Patient patient;
		
		public Entity(int key, Patient patient){
			this.key=key;
			this.patient=patient;
		}
	}
	private LinkedList<Entity>[] patientsTable;
	private int capacity;
	private int patients;
	private static final double A=Math.sqrt(5-1)/2;
	private static final double LOAD_FACTOR_THRESHOLD=0.75;
		
	public CustomHashMap(int capacity){
		this.capacity=capacity;
		this.patients=0;
		patientsTable=new LinkedList[capacity];
		for(int i=0; i<capacity; i++){
			patientsTable[i]=new LinkedList<>();
		}
	}
	//Multiplication Hash funciton to avoid the colission
	private int hashFunction(int key){
		double fractionalPart=(key*A)%1;
		return (int) Math.floor(capacity*fractionalPart);
	}
	//Load factor for determing how much the hash table is currently full
	private double loadFactor(){
		return (double)patients/capacity;
	}
	//Add patient method to add the patients with their id as a key and other details
	public void addPatient(int key,Patient patient){
		if(loadFactor()>=LOAD_FACTOR_THRESHOLD){
			rehash();
		}
		int index=hashFunction(key);
		LinkedList<Entity> bucket=patientsTable[index];
		for(Entity entity:bucket){
			if(entity.key==key){
				entity.patient=patient;
				return;
			}
		}
		
		bucket.add(new Entity(key,patient));
		patients++;
	}
	//Get patient mehtod for easy look up operations 
	public Patient getPatient(int key){
		int index=hashFunction(key);
		LinkedList<Entity> bucket=patientsTable[index];
		for(Entity entity:bucket){
			if(entity.key==key){
				return entity.patient;
			}
		}
		return null;
	}
	//Rehash method to resize the hash table if loadFactor acceed to the load threshold
	private void rehash(){
		int newCapacity=capacity*2;
		LinkedList<Entity>[] oldTable=patientsTable;
		
		patientsTable=new LinkedList[newCapacity];
	
		for(int i=0; i<newCapacity; i++){
			patientsTable[i]=new LinkedList<>();
		}
		capacity=newCapacity;
		patients=0;
		
		
		for(LinkedList<Entity> bucket:oldTable){
			for(Entity entity:bucket){
				addPatient(entity.key,entity.patient);
			}
		}
	}
	//Display method to display the patients records
	public void displayPatientsRecords(){
		for(int i=0; i<capacity; i++){
			LinkedList<Entity> bucket=patientsTable[i];
			for(Entity entity:bucket){
				System.out.println("Key: "+entity.key+", "+entity.patient);
			}
		}
	}
	
	public boolean remove(int key){
		int index=hashFunction(key);
		LinkedList<Entity> bucket=patientsTable[index];
		for(Entity entity:bucket){
			if(entity.key==key){
				bucket.remove(entity);
				capacity--;
				return true;
			}
		}
		return false;
	}
}
