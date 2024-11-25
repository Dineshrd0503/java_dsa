public class PermutationsBacktracking {
    public static void main(String[] args){
        String s="abcd";
        printpermutations(s,"",0);
    }
    public static void printpermutations(String s,String perm,int index){
        if(s.length()==0){
            System.out.println(perm);
            return;
        }
        for(int i=0;i<s.length();i++){
            char currchar=s.charAt(i);
            String newstr=s.substring(0,i)+s.substring(i+1);
            printpermutations(newstr,perm+currchar,index+1);
        }
    }
    
}
