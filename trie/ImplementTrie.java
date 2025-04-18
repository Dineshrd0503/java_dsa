package trie;

// Problem Statement:
// Implement a Trie class and complete the insert(), search(), and isPrefix() function for the following queries:
// Type 1: (1, word) - calls insert(word) function and inserts the word in the Trie.
// Type 2: (2, word) - calls search(word) function and checks whether the word exists in the Trie or not.
// Type 3: (3, word) - calls isPrefix(word) function and checks whether the word exists as a prefix of any string in the Trie.

// Example 1:
// Input: query[][] = [[1, "abcd"], [1, "abc"], [1, "bcd"], [2, "bc"], [3, "bc"], [2, "abc"]]
// Output: [false, true, true]

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        this.children = new TrieNode[26]; // Assuming only lowercase 'a' to 'z'
        this.isEndOfWord = false;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    // Search for a word in the Trie
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return false; // Word not found
            }
            node = node.children[index];
        }
        return node.isEndOfWord; // Check if it's the end of a valid word
    }

    // Check if a prefix exists in the Trie
    public boolean isPrefix(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return false; // Prefix not found
            }
            node = node.children[index];
        }
        return true; // Prefix exists
    }
}

// Main class to run the Trie operations
public class ImplementTrie {
    public static void main(String[] args) {
        Trie trie = new Trie();

        // Sample input: steps for type 1, 2, and 3
        String[] wordsToInsert = {"abcd", "abc", "bcd"};
        for (String word : wordsToInsert) {
            trie.insert(word);
        }

        // Searching for words
        System.out.println(trie.search("bc"));   // Output: false
        System.out.println(trie.search("abc"));  // Output: true
        System.out.println(trie.isPrefix("bc")); // Output: true (as it's a prefix of "bcd")
        System.out.println(trie.isPrefix("fg")); // Output: false
        System.out.println(trie.search("for"));  // Output: false (not inserted)
    }
}