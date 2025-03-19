package codingninjas7dayschallenge;

import java.util.ArrayList;


//A character in UTF-8 can be from 1 to 4 bytes long, subjected to the following rules:
//
//        1. For a 1-byte character, the first bit is a 0, followed by its Unicode code.
//
//2. For n-bytes characters, the first n-bits are all one’s, and the n + 1 bit is 0, followed by n - 1 bytes, with the most significant 2 bits being 10.
//
//You are given an array 'DATA' of integers representing the data, Your task is to find out whether the given array is a valid UTF-8 encoding.
//
//        Note:
//
//The given input contains only integers, and only the least significant 8 bits of each integer is used to store the data. This means each integer represents only 1 byte of data.
//        Example:
//Given data = [196, 128, 1], which represents the octet sequence: 11000101 10000010 00000001.
//
//Return true because this is a valid UTF-8 sequence for a 2-byte character followed by a 1-byte character.
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1 :
//        2
//        3
//        232 136 4
//        3
//        196 128 1
//Sample Output 1 :
//        false
//        true
//Explanation of the Sample Output 1:
//In test case 1,The array which represented the octet sequence: 11101000 10001100 00000100.
//
//The first 3 bits are all ones, and the 4th bit is 0 means it is a 3-byte character.
//
//The next byte is a continuation byte that starts with 10, and that’s correct, but the second continuation byte does not start with 10, so it is invalid and hence we return false.
//
//In test case 2, The array which represented the octet sequence: which represents the octet sequence: 11000100 10000000 00000001.
//
//It is a valid UTF-8 encoding for a 2-byte character followed by a 1-byte character, therefore we return true.
//Sample Input 2 :
//        2
//        1
//        1
//        1
//        255
//Sample Output 2 :
//        true
//        false



public class ValidUTF8Validation {
    public static boolean validUtf8(ArrayList<Integer> data) {
        // Write your code here.
        int num_of_bytes = 0; // Number of bytes to process

        for (int value : data) {
            // Check if we're in the middle of processing a multi-byte character
            if (num_of_bytes > 0) {
                // Check if this byte is a continuation byte
                if ((value >> 6) != 0b10) {
                    return false; // Not a valid continuation byte
                }
                num_of_bytes--; // Process one continuation byte
            } else {
                // Determine how many bytes this character will use
                if ((value >> 7) == 0b0) {
                    num_of_bytes = 0; // 1-byte character (0xxxxxxx)
                } else if ((value >> 5) == 0b110) {
                    num_of_bytes = 1; // 2-byte character (110xxxxx)
                } else if ((value >> 4) == 0b1110) {
                    num_of_bytes = 2; // 3-byte character (1110xxxx)
                } else if ((value >> 3) == 0b11110) {
                    num_of_bytes = 3; // 4-byte character (11110xxx)
                } else {
                    return false; // Invalid UTF-8 starting byte
                }
            }
        }

        // Ensure all characters were fully processed
        return num_of_bytes == 0;
    }

    public static void main(String[] args) {
        ArrayList<Integer> data = new ArrayList<>();
        data.add(197);
        data.add(130);
        data.add(1);
        System.out.println(validUtf8(data));
    }
}
