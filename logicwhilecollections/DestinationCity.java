package logicwhilecollections;
import java.util.*;

public class DestinationCity {

    /**
     * Problem Description:
     * Given an array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path
     * going from cityAi to cityBi. Return the destination city, that is, the city without any
     * path outgoing to another city.
     *
     * It is guaranteed that the graph of paths forms a line without any loop, therefore, there
     * will be exactly one destination city.
     *
     * Constraints:
     * 1 <= paths.length <= 100
     * paths[i].length == 2
     * 1 <= cityAi.length, cityBi.length <= 10
     * cityAi != cityBi
     * All strings consist of lowercase and uppercase English letters and the space character.
     *
     * Example 1:
     * Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
     * Output: "Sao Paulo"
     * Explanation: Starting at "London" city you will reach "Sao Paulo" city which is the destination city.
     * Your trip consist of: "London" -> "New York" -> "Lima" -> "Sao Paulo".
     *
     * Example 2:
     * Input: paths = [["B","C"],["D","B"],["C","A"]]
     * Output: "A"
     * Explanation: All possible trips are:
     * "D" -> "B" -> "C" -> "A".
     * "B" -> "C" -> "A".
     * "C" -> "A".
     * "A".
     * Clearly the destination city is "A".
     *
     * Example 3:
     * Input: paths = [["A","Z"]]
     * Output: "Z"
     */
    public String destCity(List<List<String>> paths) {
        Set<String> startingCities = new HashSet<>();

        // Collect all cities which have outgoing paths (start cities)
        for (List<String> path : paths) {
            startingCities.add(path.get(0));
        }

        // The destination city is the one that never appears as a start city
        for (List<String> path : paths) {
            String destination = path.get(1);
            if (!startingCities.contains(destination)) {
                return destination;
            }
        }

        // According to constraints, this should never be reached
        return "";
    }

    public static void main(String[] args) {
        DestinationCity solution = new DestinationCity();
        List<List<String>> paths1 = Arrays.asList(
                Arrays.asList("London", "New York"),
                Arrays.asList("New York", "Lima"),
                Arrays.asList("Lima", "Sao Paulo")
        );
        System.out.println("Destination city (Test case 1): " + solution.destCity(paths1)); // Expected: Sao Paulo

        List<List<String>> paths2 = Arrays.asList(
                Arrays.asList("B", "C"),
                Arrays.asList("D", "B"),
                Arrays.asList("C", "A")
        );
        System.out.println("Destination city (Test case 2): " + solution.destCity(paths2)); // Expected: A

        List<List<String>> paths3 = Collections.singletonList(
                Arrays.asList("A", "Z")
        );
        System.out.println("Destination city (Test case 3): " + solution.destCity(paths3)); // Expected: Z
    }
}

