package arrays;
/*
    Problem Statement:
    ------------------
    Given an array 'keys' of N non-negative integers, implement a hash table of size N using linear probing.
    Hash function: index = key % N
    Insert each key into the table. If the computed index is occupied, use the next available slot (linear probing, wrap around).
    If a slot is empty, it's represented by -1.

    Output: After inserting all keys, return the hash table as an array.
*/

import java.util.*;

public class LinearProbing {
    // Function to perform linear probing
    public static int[] linearProbing(List<Integer> keys) {
        int N = keys.size();
        int[] table = new int[N];
        Arrays.fill(table, -1); // initialize all slots as empty (-1)

        for (int key : keys) {
            int idx = key % N;
            // Linear probing until an empty slot is found
            while (table[idx] != -1) {
                idx = (idx + 1) % N; // wrap around if necessary
            }
            table[idx] = key;
        }

        return table;
    }

    // Main method to read input and print output
    public static void main(String[] args) {
        // Static input for demonstration
        List<Integer> keys = new ArrayList<>();
        keys.add(50);
        keys.add(700);
        keys.add(76);
        keys.add(85);
        keys.add(92);
        keys.add(73);
        keys.add(101);

        int[] hashTable = linearProbing(keys);
        for (int val : hashTable) {
            System.out.print(val + " ");
        }
    }
}
