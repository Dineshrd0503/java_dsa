public class AddCharToString {
    public static void main(String[] args){
        String s = "Hello world";
       shiftchar(s,0,0,"",'l');
    }
    public static void shiftchar(String s,int index,int count,String newstr,char target){
        if(index==s.length()){
            for(int i=0;i<count;i++)
            newstr+=target;
            System.out.println(newstr);
            return;
    }
    if(s.charAt(index)==target){
        count+=1;
        shiftchar(s,index+1,count,newstr,target);
    }
    else{
        newstr+=s.charAt(index);
        shiftchar(s,index+1,count,newstr,target);
    } 
       
    
}
}
