public class StringPermutations {
    public static void main(String[] args) {
        String str = "abc";
        //counting the possible permutations of a string
        permutations(str,"");
    }
    
    public static void permutations(String str, String prefix) {
        if(str.length()==0){
            System.out.println(prefix);
            return;
        }
        for(int i=0;i<str.length();i++){
            char currchar=str.charAt(i);
            String newstr=str.substring(0,i)+str.substring(i+1);
            permutations(newstr,prefix+currchar);
        }
    
}
}
