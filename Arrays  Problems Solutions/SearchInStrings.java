package ArrayImportantProblems;

public class SearchInStrings {
	public static void main(String[] args) {
		String name="Ahsan";
//		char letter='w';
		char letter='s';
		boolean ans=searchLetter(name,letter);
		System.out.println("Ans is: "+ans);
		
	}
	public static boolean searchLetter(String str, char character) {
		if(str.length()==0) {
			return false;
		}
		for(int index=0; index<str.length();index++) {
			if(character==str.charAt(index)) {
				return true;
			}
		}
		return false;
	}
}
