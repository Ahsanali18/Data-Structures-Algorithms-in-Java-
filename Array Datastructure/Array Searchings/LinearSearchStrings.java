package SearchingAlgorithms;
public class LinearSearchStrings {
    public static void main(String[] args) {
        String[] names={"Ahsan","Ahmed","Sachin","Husnaak","Kabeer","Nouman","Basit","Soorat","Varoon"};
        String target="Ahsan";
        String answer=linearSearch(names,target);
        System.out.println("Answer is: "+answer);
    }
    public static String linearSearch(String[] names, String target){
        if(names.length==0)
            return null;
        for(int index=0; index<names.length; index++){
            String name=names[index];
            if(name==target)
                return target;
        }
        return "Default Name";
    }
}
