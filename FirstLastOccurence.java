import java.util.*;
public class FirstLastOccurence{
    public static void main(String[] args){
        String s="racecar";
        firstlastoccurence(s,'c',0);
    }
    
    public static void firstlastoccurence(String s,char target,int index){
        Map<Character,Integer> frequency=new HashMap<>();
        for(char c:s.toCharArray()){
            frequency.put(c,frequency.getOrDefault(c,0)+1);
        }
        for (Map.Entry<Character,Integer> entry : frequency.entrySet()) {
           System.out.println(entry.getKey()+":"+entry.getValue());
            
        }

        
       }

    }