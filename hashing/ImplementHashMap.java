package hashing;

/**
 * Problem: Design a HashMap without using any built-in hash table libraries.
 * Implement the MyHashMap class:
 * - MyHashMap() initializes the object with an empty map.
 * - void put(int key, int value) inserts a (key, value) pair into the HashMap.
 *   If the key already exists in the map, update the corresponding value.
 * - int get(int key) returns the value to which the specified key is mapped,
 *   or -1 if this map contains no mapping for the key.
 * - void remove(key) removes the key and its corresponding value if the map
 *   contains the mapping for the key.
 */
public class ImplementHashMap {

    private static final int SIZE = 1000001;
    private Integer[] arr;

    /**
     * Initialize your data structure here.
     */
    public ImplementHashMap() {
        arr = new Integer[SIZE];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        arr[key] = value;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map
     * contains no mapping for the key
     */
    public int get(int key) {
        return arr[key] == null ? -1 : arr[key];
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping
     * for the key
     */
    public void remove(int key) {
        arr[key] = null;
    }

    public static void main(String[] args) {
        // Example usage of MyHashMap
        ImplementHashMap myHashMap = new ImplementHashMap();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(1)); // return 1, The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(3)); // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        System.out.println(myHashMap.get(2)); // return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        System.out.println(myHashMap.get(2)); // return -1 (i.e., not found), The map is now [[1,1]]
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj =
 * new MyHashMap(); obj.put(key,value); int param_2 = obj.get(key);
 * obj.remove(key);
 */