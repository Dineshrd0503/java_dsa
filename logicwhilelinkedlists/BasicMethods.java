package logicwhilelinkedlists;

import java.util.LinkedList;

public class BasicMethods {
    public static void main(String[] args) {
        // LinkedList implements the List interface but has additional methods
        // for adding/removing from the beginning and end of the list.
        LinkedList<String> animals = new LinkedList<>();

        // 1. add(E e): Appends the specified element to the end of this list.
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Horse");
        System.out.println("Initial LinkedList: " + animals); // Output: [Dog, Cat, Horse]

        // 2. add(int index, E element): Inserts the element at a specific position.
        animals.add(1, "Tiger");
        System.out.println("After adding Tiger at index 1: " + animals); // Output: [Dog, Tiger, Cat, Horse]

        // 3. addFirst(E e): Inserts the given element at the beginning of this list.
        animals.addFirst("Lion");
        System.out.println("After addFirst: " + animals); // Output: [Lion, Dog, Tiger, Cat, Horse]

        // 4. addLast(E e): Appends the given element to the end of this list. (Same as add())
        animals.addLast("Elephant");
        System.out.println("After addLast: " + animals); // Output: [Lion, Dog, Tiger, Cat, Horse, Elephant]

        // 5. get(int index): Returns the element at the specified position.
        String firstAnimal = animals.get(0);
        System.out.println("Element at index 0: " + firstAnimal); // Output: Lion

        // 6. getFirst(): Returns the first element in this list.
        System.out.println("First element using getFirst(): " + animals.getFirst()); // Output: Lion

        // 7. getLast(): Returns the last element in this list.
        System.out.println("Last element using getLast(): " + animals.getLast()); // Output: Elephant

        // 8. remove(int index): Removes the element at the specified position.
        String removedAnimal = animals.remove(2); // Removes "Tiger"
        System.out.println("Removed element at index 2: " + removedAnimal);
        System.out.println("List after removing element at index 2: " + animals); // Output: [Lion, Dog, Cat, Horse, Elephant]

        // 9. remove(Object o): Removes the first occurrence of the specified element.
        boolean wasRemoved = animals.remove("Cat");
        System.out.println("Was 'Cat' removed? " + wasRemoved); // Output: true
        System.out.println("List after removing 'Cat': " + animals); // Output: [Lion, Dog, Horse, Elephant]

        // 10. removeFirst(): Removes and returns the first element from this list.
        String head = animals.removeFirst();
        System.out.println("Removed first element: " + head); // Output: Lion
        System.out.println("List after removeFirst: " + animals); // Output: [Dog, Horse, Elephant]

        // 11. removeLast(): Removes and returns the last element from this list.
        String tail = animals.removeLast();
        System.out.println("Removed last element: " + tail); // Output: Elephant
        System.out.println("List after removeLast: " + animals); // Output: [Dog, Horse]

        // 12. set(int index, E element): Replaces the element at the specified position.
        animals.set(1, "Zebra");
        System.out.println("List after setting index 1 to 'Zebra': " + animals); // Output: [Dog, Zebra]

        // 13. size(): Returns the number of elements in this list.
        System.out.println("Current size of the list: " + animals.size()); // Output: 2

        // 14. contains(Object o): Returns true if this list contains the specified element.
        boolean hasDog = animals.contains("Dog");
        System.out.println("Does the list contain 'Dog'? " + hasDog); // Output: true

        // 15. indexOf(Object o): Returns the index of the first occurrence of the specified element.
        int indexOfZebra = animals.indexOf("Zebra");
        System.out.println("Index of 'Zebra': " + indexOfZebra); // Output: 1

        // 16. clear(): Removes all of the elements from this list.
        animals.clear();
        System.out.println("List after clear(): " + animals); // Output: []

        // 17. isEmpty(): Returns true if this list contains no elements.
        System.out.println("Is the list empty now? " + animals.isEmpty()); // Output: true
    }
}