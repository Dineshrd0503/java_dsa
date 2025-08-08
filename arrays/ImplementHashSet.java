package arrays;

// Problem Statement:
// Design a HashSet without using any built-in hash table libraries.
// Implement MyHashSet class:
//   void add(key) Inserts the value key into the HashSet.
//   bool contains(key) Returns whether the value key exists in the HashSet or not.
//   void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
// Constraints:
//   0 <= key <= 106
//   At most 104 calls will be made to add, remove, and contains.

public class ImplementHashSet {

    private boolean[] set;
    private int capacity;

    // Constructor
    public ImplementHashSet() {
        capacity = 1000001; // As per constraints the key will be <= 10^6
        set = new boolean[capacity];
    }

    // Inserts the value key into the HashSet.
    public void add(int key) {
        set[key] = true;
    }

    // Returns whether the value key exists in the HashSet or not.
    public boolean contains(int key) {
        return set[key];
    }

    // Removes the value key in the HashSet.
    public void remove(int key) {
        set[key] = false;
    }


    // QuickSort implementation is not relevant for HashSet design problem
    // QuickSort is a sorting algorithm , while this is to create a hashset with some functionalities specified in the problem statement
    // Since capacity is limited a boolean array implementation suits best for the problem.

    public static void main(String[] args) {
        ImplementHashSet myHashSet = new ImplementHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(1)); // return True
        System.out.println(myHashSet.contains(3)); // return False, (not found)
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(2)); // return True
        myHashSet.remove(2);   // set = [1]
        System.out.println(myHashSet.contains(2)); // return False, (already removed)
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
