package BlockChainHashing;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

class PasswordHashing{
	public static String generatePasswordHash(String password){
		try{
			MessageDigest dig=MessageDigest.getInstance("SHA-256");
			byte[] hashBytes=dig.digest(password.getBytes());
			StringBuilder hexDecimalString=new StringBuilder();
			
			for(byte b:hashBytes){
				String hexValue=Integer.toHexString(0xff & b);
				
				if(hexValue.length()==1){
					hexDecimalString.append('0');
				}
				hexDecimalString.append(hexValue);
			}
			return hexDecimalString.toString();
		}catch(NoSuchAlgorithmException e){
			throw new RuntimeException(e);
		}
	}
}

public class UserAuthentication{
	private String[] userNames;
	private String[] passwords;
	private int userCount;
	
	public UserAuthentication(int capacity){
		userNames=new String[capacity];
		passwords=new String[capacity];
		userCount=0;
	}
	
	public void addUser(String userName, String password){
		if(userCount<userNames.length){
			String hashedPassword=PasswordHashing.generatePasswordHash(password);
			userNames[userCount]=userName;
			passwords[userCount]=hashedPassword;
			userCount++;
		}else{
			System.out.println("User capacity reached!");
		}
	}
	
	public boolean verifyUser(String userName, String password){
		String hashedPassword=PasswordHashing.generatePasswordHash(password);
		
		for(int i=0; i<userCount; i++){
			if(userNames[i].equals(userName) && passwords[i].equals(hashedPassword)){
				return true;
			}
		}
		return false;
	}
	
	public void displayUsers(){
		System.out.println("Available Users at our application");
		for(int i=0; i<userCount; i++){
			System.out.println("Username: "+userNames[i]+" Hashed password: "+passwords[i]);
		}
	}
	
	public static void main(String[] args) {
		UserAuthentication authSystem=new UserAuthentication(10);
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter username: ");
		String userName=sc.nextLine();
		
		System.out.print("Enter password: ");
		String password=sc.nextLine();
		
		authSystem.addUser(userName, password);
		System.out.println("User added successfully!");
		
		authSystem.displayUsers();
		
		System.out.print("Enter username to verify: ");
		String verifyUserName=sc.nextLine();
		
		System.out.print("Enter password to verify: ");
		String verifyPassword=sc.nextLine();
		
		if(authSystem.verifyUser(verifyUserName, verifyPassword)){
			System.out.println("User's data present at our application!");
		}else{
			System.out.println("Invalid password/username (Access Denied)!");
		}
	}
}
