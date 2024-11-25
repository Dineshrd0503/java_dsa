package codingninjas;

public class CaptalizeLetters {
    public static void main(String[] args) {
        String str="I am HAppy";
        System.out.println(makecapital(str));

    }

public static String makecapital(String str){
        String[] words=str.split("\\s+");
        for(int i=0;i< words.length;i++)
            words[i]=words[i].substring(0,1).toUpperCase()+words[i].substring(1);
        return String.join(" ",words);

        }
}
