package recursiveApproach;

public class TowerOfHanoi{
	/*
	 								Algorithm
	 	Step:1 Move (n-1) disks from source to the auxilary
	 	Step:2 Move the last disk from source to the destination
	 	Step:3 Move (n-1) disks from auxilary to the destination
	 */
	public void towerOfHanoi(int disks,char source, char destination, char auxilary){
		if(disks==1){
			System.out.println("Base: "+source+" --> "+destination);
		}
		else{
			towerOfHanoi(disks-1,source,auxilary,destination);
			System.out.println("Moving disk: "+disks+" to destination");
			towerOfHanoi(disks-1,auxilary,destination,source);
		}
	}
	
	public static void main(String[] args) {
		TowerOfHanoi tower=new TowerOfHanoi();
		tower.towerOfHanoi(4, 'A', 'B', 'C');
	}

}
