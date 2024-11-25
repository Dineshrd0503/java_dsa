import java.util.*;
public class InterviewQue{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int n=sc.nextInt();
        System.out.println("fibbonacci series upto "+n+" is");
        for(int i=0;i<n;i++)
        System.out.print(fibbonacci(i)+" ");
        System.out.println("\nEnter two number ");
        int n1=sc.nextInt();
        int n2=sc.nextInt();
        int r1=gcd(n1,n2);
        System.out.println("gcd of "+n1+", "+n2+" is "+r1);
        sc.nextLine();
        System.out.println("enter two strings");
        String str1=sc.nextLine();
        String str2=sc.nextLine();
        System.out.println("checking if they are anagarms");
        if(isanagram(str1,str2)=="true")
        System.out.println("strings are anagrams"); 
        else
        System.out.println("strings are not anagrmas");
        System.out.println("Enter a new string");
        String str3=sc.nextLine();
        if(revstr(str3).equals(str3))
        System.out.println(str3+" is palindrome");
        else
        System.out.println(str3+" is not palindrome");
        System.out.println("enter new String");
        String str4=sc.nextLine();
        System.out.println("calcualting frequency of characters");
        charfrequency(str4);

    }
    public static int fibbonacci(int n){
        if(n==0||n==1)
        return n;
        else
        return fibbonacci(n-1)+fibbonacci(n-2);


}
    public static int gcd(int a,int b){
        if(b==0)
        return a;
        else
        return gcd(b,a%b);
    }
    public static String isanagram(String str1,String str2){
        if(str1.length()!=str2.length())
        return "false";
        char[] a=str1.toCharArray();
        char[] b=str2.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a,b)?"true":"false";
    }
    public static String revstr(String str){
        StringBuilder sb=new StringBuilder(str);
        return sb.reverse().toString();
    }
    public static void charfrequency(String str){
        Map<Character,Integer> map=new HashMap<>();
        for(char c:str.toCharArray()){
            if(map.containsKey(c))
            map.put(c,map.get(c)+1);
            else
            map.put(c,1);
        }
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            System.out.println(entry.getKey()+": "+entry.getValue());

        }
        for(Character c:map.keySet())
        System.out.println(c+":"+map.get(c));

    }
}