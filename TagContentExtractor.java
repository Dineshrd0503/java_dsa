import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TagContentExtractor {
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
         String regex = "<([^<>]+)>([^<>]+)</\\1>";
      Pattern pattern = Pattern.compile(regex);
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases>0){
			String line = in.nextLine();
         Matcher matcher = pattern.matcher(line);
         int counter = 0;
         while (matcher.find()) {
             System.out.println(matcher.group(2));
             counter++;
         }
         if (counter == 0) System.out.println("None");
          	//Write your code here
			
			testCases--;
		}
	}
}



