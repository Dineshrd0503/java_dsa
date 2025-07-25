package logicwhilecollections;

import java.util.ArrayList;
import java.util.List;

public class BasicMethods {
    public static void main(String[] args) {
        // Create a new ArrayList to store integers
        List<Integer> myList = new ArrayList<>();

        // 1. add(E element): Appends the specified element to the end of this list.
        myList.add(10);
        myList.add(20);
        myList.add(30);
        System.out.println("After adding elements: " + myList); // Output: [10, 20, 30]

        // 2. add(int index, E element): Inserts the specified element at the specified position in this list.
        myList.add(1, 15);
        System.out.println("After adding 15 at index 1: " + myList); // Output: [10, 15, 20, 30]

        // 3. get(int index): Returns the element at the specified position in this list.
        int elementAtIndex2 = myList.get(2);
        System.out.println("Element at index 2: " + elementAtIndex2); // Output: 20

        // 4. set(int index, E element): Replaces the element at the specified position in this list with the specified element.
        myList.set(0, 5);
        System.out.println("After setting element at index 0 to 5: " + myList); // Output: [5, 15, 20, 30]

        // 5. remove(int index): Removes the element at the specified position in this list.
        myList.remove(3);
        System.out.println("After removing element at index 3: " + myList); // Output: [5, 15, 20]

        // 6. remove(Object o): Removes the first occurrence of the specified element from this list, if it is present.
        myList.add(15); // Add 15 again to demonstrate removing first occurrence
        System.out.println("List before removing object 15: " + myList); // Output: [5, 15, 20, 15]
        myList.remove(Integer.valueOf(15)); // Use Integer.valueOf for object removal
        System.out.println("After removing first occurrence of 15: " + myList); // Output: [5, 20, 15]
        // 7. size(): Returns the number of elements in this list.
        int size = myList.size();
        System.out.println("Size of the list: " + size); // Output: 3
        // 8. isEmpty(): Returns true if this list contains no elements.
        boolean isEmpty = myList.isEmpty();
        System.out.println("Is the list empty? " + isEmpty); // Output: false
        // 9. clear(): Removes all of the elements from this list.
        myList.clear();
        System.out.println("After clearing the list: " + myList); // Output: []
        // 10. contains(Object o): Returns true if this list contains the specified element.
        myList.add(10);
        myList.add(20);
        boolean contains20 = myList.contains(20);
        System.out.println("Does the list contain 20? " + contains20); // Output
        // Output: true
        boolean contains30 = myList.contains(30);
        System.out.println("Does the list contain 30? " + contains30); // Output
        // Output: false
        // 11. indexOf(Object o): Returns the index of the first occurrence of the
        // specified element in this list, or -1 if this list does not contain the element
        int indexOf10 = myList.indexOf(10);
        System.out.println("Index of 10: " + indexOf10); // Output:
        // Output: 0
        int indexOf20 = myList.indexOf(20);
        System.out.println("Index of 20: " + indexOf20); // Output:
        // Output: 1
        int indexOf30 = myList.indexOf(30);
        System.out.println("Index of 30: " + indexOf30); // Output:
        // Output: -1 (not found)
        // 12. lastIndexOf(Object o): Returns the index of the last occurrence of the
        // specified element in this list, or -1 if this list does not contain the element
        myList.add(10);
        myList.add(20);
        myList.add(10); // Adding another 10 to demonstrate lastIndexOf
        int lastIndexOf10 = myList.lastIndexOf(10);
        System.out.println("Last index of 10: " + lastIndexOf10); //
        // Output: 2 (last occurrence) // Output: [10, 20, 10, 20, 10]

        // 13. addAll(Collection c): Appends all elements from another collection.
        List<Integer> anotherList = new ArrayList<>();
        anotherList.add(100);
        anotherList.add(200);
        myList.addAll(anotherList);
        System.out.println("After addAll: " + myList); // Output: [10, 20, 10, 20, 10, 100, 200]

        // 14. removeAll(Collection c): Removes all elements that are also in another collection.
        List<Integer> toRemove = new ArrayList<>();
        toRemove.add(10);
        toRemove.add(100);
        myList.removeAll(toRemove);
        System.out.println("After removeAll(10, 100): " + myList); // Output: [20, 20, 200]

        // 15. subList(int fromIndex, int toIndex): Returns a view of the portion of this list.
        myList.add(300);
        myList.add(400);
        System.out.println("List before subList: " + myList); // Output: [20, 20, 200, 300, 400]
        List<Integer> sub = myList.subList(1, 4);
        System.out.println("Sublist from index 1 to 4: " + sub); // Output: [20, 200, 300]
        // Note: Changes to the sublist will affect the original list.
        sub.set(0, 25);
        System.out.println("Original list after modifying sublist: " + myList); // Output: [20, 25, 200, 300, 400]

        // 16. toArray(): Returns an array containing all of the elements in this list.
        Object[] array = myList.toArray();
        System.out.println("Array from list: " + java.util.Arrays.toString(array)); // Output: [20, 25, 200, 300, 400]

        // 17. forEach(Consumer action): Performs the given action for each element using a lambda.
        System.out.print("Using forEach to print elements: ");
        myList.forEach(element -> System.out.print(element + " ")); // Output: 20 25 200 300 400
        System.out.println();

    }
}
