package codingninjas6monthschallenge;

import java.util.ArrayList;

public class UTF8Valdation {
    public static boolean validUtf8(ArrayList<Integer> data) {
        // Write your code here.
        int remainingBytes = 0; // Tracks continuation bytes needed

        for (int num : data) {
            // Extract only the least significant 8 bits
            int byteVal = num & 0xFF;

            if (remainingBytes == 0) {
                // Determine the number of bytes in the current UTF-8 character
                if ((byteVal >> 7) == 0b0) {
                    // 1-byte character (starts with 0)
                    continue;
                } else if ((byteVal >> 5) == 0b110) {
                    // 2-byte character (starts with 110)
                    remainingBytes = 1;
                } else if ((byteVal >> 4) == 0b1110) {
                    // 3-byte character (starts with 1110)
                    remainingBytes = 2;
                } else if ((byteVal >> 3) == 0b11110) {
                    // 4-byte character (starts with 11110)
                    remainingBytes = 3;
                } else {
                    // Invalid starting byte
                    return false;
                }
            } else {
                // Check continuation bytes (must start with "10")
                if ((byteVal >> 6) != 0b10) {
                    return false;
                }
                remainingBytes--; // One continuation byte processed
            }
        }

        // If there are leftover continuation bytes, it's invalid
        return remainingBytes == 0;
    }

    public static void main(String[] args) {
        ArrayList<Integer> data = new ArrayList<>();
        data.add(197);
        data.add(130);
        data.add(1);
        System.out.println(validUtf8(data));
    }
}
