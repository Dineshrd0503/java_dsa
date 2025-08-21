package strings;

import java.util.*;
import java.io.*;

public class HotelFloors {

    /**
     * You are the receptionist at a hotel which has 10 floors, numbered from 0 to 9 and each floor has 26 rooms named from ‘A’ to ‘Z’.
     * Being a receptionist your task is to handle booking queries.
     *
     * You get booking queries in the form of strings of size 3 where 1st character is ‘+’ means room is booked, or ‘-’ means room is freed.
     * Second character represents the floor of the room i.e, ‘0’ to ‘9’. Third character represents the room name i.e, ‘A’ to ‘Z’.
     *
     * On booking of each room you collect 1 coin from the customer. After the end of all the booking queries you have to count the number of coins you collected.
     *
     * You may assume that the list describes a correct sequence of bookings in chronological order i.e., only free rooms can be booked, and only booked rooms can be freed.
     *
     * For Example:-
     *
     * Consider booking queries to be ["+1A", "+3E", "-1A", "+4F", "+1A", "-3E"]
     * +1A: Room A on the 1st floor is booked and you collected 1 coin.
     * +3E: Room E on the 3rd floor is booked and you collected 1 coin.
     * -1A: Room A on the 1st floor is freed.
     * +4F: Room F on the 4th floor is booked and you collected 1 coin.
     * +1A: Room A on the 1st floor is booked and you collected 1 coin.
     * -3E: Room E on the 3rd floor is freed.
     * So you collected 4 coins.
     *
     * Input format:
     *
     * The first line of input contains an integer ‘T’ denoting the number of test cases.
     *
     * The first line of each test case contains an integer ‘N’ representing the number of queries.
     *
     * The second line of each test case contains N space-separated strings representing booking queries.
     *
     * Output format :
     *
     * For each test case, return an integer denoting the count of coins you collected.
     *
     * Note:
     *
     * You don’t need to print anything; it has already been taken care of. Just implement the given function.
     *
     * Constraints:
     *
     * 1 <= T <= 10^2
     * 0 <= N <= 6*10^2
     * |query.length| = 3
     *
     * Time Limit: 1 sec
     */
    public static int hotelBookings(List<String> queries) {
        // Initialize the number of coins collected
        int coins = 0;

        // Use a Set to keep track of the rooms that are currently booked.
        Set<String> bookedRooms = new HashSet<>();

        // Iterate through the list of queries
        for (String query : queries) {
            // Extract the operation type (+ or -) from the query
            char operation = query.charAt(0);

            // Extract the room number (e.g., "1A") from the query
            String room = query.substring(1);

            // If the operation is '+', it means a room is being booked
            if (operation == '+') {
                // Check if the room is already booked
                if (!bookedRooms.contains(room)) {
                    // If the room is not booked, add it to the set of booked rooms
                    bookedRooms.add(room);

                    // Increment the number of coins collected
                    coins++;
                }
            }
            // If the operation is '-', it means a room is being freed
            else if (operation == '-') {
                // Remove the room from the set of booked rooms
                bookedRooms.remove(room);
            }
        }

        // Return the total number of coins collected
        return coins;
    }

    public static void main(String[] args) {
        // Test case 1
        List<String> queries1 = Arrays.asList("+1A", "+3E", "-1A", "+4F", "+1A", "-3E");
        int coins1 = hotelBookings(queries1);
        System.out.println("Test Case 1: Coins collected = " + coins1);  // Expected output: 4

        // Test case 2
        List<String> queries2 = Arrays.asList("+0A", "+0B", "+0C");
        int coins2 = hotelBookings(queries2);
        System.out.println("Test Case 2: Coins collected = " + coins2);  // Expected output: 3

        // Test case 3
        List<String> queries3 = Arrays.asList("+8D", "-8D", "+8D", "-8D");
        int coins3 = hotelBookings(queries3);
        System.out.println("Test Case 3: Coins collected = " + coins3); // Expected output: 2

        // Test case 4
        List<String> queries4 = Arrays.asList("+3C", "+2B", "+7K", "-2B", "+6C", "-3C", "+5S");
        int coins4 = hotelBookings(queries4);
        System.out.println("Test Case 4: Coins collected = " + coins4); // Expected output: 5

        // Test case 5 (empty list)
        List<String> queries5 = new ArrayList<>();
        int coins5 = hotelBookings(queries5);
        System.out.println("Test Case 5: Coins collected = " + coins5); // Expected output: 0

        // Test case 6 (Only freeing)
        List<String> queries6 = Arrays.asList("-1A", "-2B");
        int coins6 = hotelBookings(queries6);
        System.out.println("Test Case 6: Coins collected = " + coins6);
    }
}
