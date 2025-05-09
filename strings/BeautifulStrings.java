package strings;
//Ninja has been given a binary string ‘STR’ containing either ‘0’ng.

//public class BeautifulStrings { or ‘1’. A binary string is called beautiful if it contains alternating 0s and 1s.
    //
//For Example:‘0101’, ‘1010’, ‘101’, ‘010’ are beautiful strings.
//
//He wants to make ‘STR’ beautiful by performing some operations on it. In one operation, Ninja can convert ‘0’ into ‘1’ or vice versa.
//
//Your task is to determine the minimum number of operations Ninja should perform to make ‘STR’ beautiful.
//
//For Example :
//Minimum operations to make ‘STR’ ‘0010’ beautiful is ‘1’. In one operation, we can convert ‘0’ at index ‘0’ (0-based indexing) to ‘1’. The ‘STR’ now becomes ‘1010’ which is a beautiful stri
    public class BeautifulStrings{
        public static int makeBeautiful(String str) {
        int n=str.length();
        int pattern1=0; //1010
        int pattern2=0; //0101
        for(int i=0;i<n;i++){
            char expectedpattern1=(i%2==0)?'1':'0';
            char expectedpattern2=(i%2==0)?'0':'1';
            if(str.charAt(i)!=expectedpattern1)
                pattern1++;
            if(str.charAt(i)!=expectedpattern2)
                pattern2++  ;
        }
        return Math.min(pattern1,pattern2);


    }

    public static void main(String[] args) {
        String str = "010011011011";
        int result = makeBeautiful(str);
        System.out.println("Minimum number of swaps to make the string beautiful: " + result);
    }
    }
