package heap;

import java.util.*;

public class KthHighestTemperature {

    /**
     * This method returns the top K cities with the highest temperatures.
     *
     * @param N Number of cities
     * @param K Number of top cities to return
     * @param cities List of cities with their temperature entries
     * @return List of top K city names with the highest temperatures
     */
    public static List<String> topKCities(int N, int K, List<Map.Entry<String, Integer>> cities) {
        // Sort the list of cities by temperature in descending order
        cities.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Prepare the result list to store the top K cities
        List<String> result = new ArrayList<>();

        // Loop through the first K cities and add their names to the result
        for (int i = 0; i < K; i++) {
            result.add(cities.get(i).getKey());
        }

        return result;
    }

    public static void main(String[] args) {
        // Sample Inputs and Outputs
        // Problem Statement: Find the top K cities with the highest temperatures.
        // Example 1
        // Input: 4 2
        // Delhi 30
        // Mumbai 35
        // Chennai 32
        // Kolkata 28
        // Expected Output: Mumbai Chennai
        List<Map.Entry<String, Integer>> cityList1 = new ArrayList<>();
        cityList1.add(new AbstractMap.SimpleEntry<>("Delhi", 30));
        cityList1.add(new AbstractMap.SimpleEntry<>("Mumbai", 35));
        cityList1.add(new AbstractMap.SimpleEntry<>("Chennai", 32));
        cityList1.add(new AbstractMap.SimpleEntry<>("Kolkata", 28));

        int N1 = cityList1.size();
        int K1 = 2;

        List<String> topCities1 = topKCities(N1, K1, cityList1);
        System.out.println(String.join(" ", topCities1)); // Output: Mumbai Chennai

        // Example 2
        // Input: 3 1
        // Pune 25
        // Bangalore 28
        // Hyderabad 26
        // Expected Output: Bangalore
        List<Map.Entry<String, Integer>> cityList2 = new ArrayList<>();
        cityList2.add(new AbstractMap.SimpleEntry<>("Pune", 25));
        cityList2.add(new AbstractMap.SimpleEntry<>("Bangalore", 28));
        cityList2.add(new AbstractMap.SimpleEntry<>("Hyderabad", 26));

        int N2 = cityList2.size();
        int K2 = 1;

        List<String> topCities2 = topKCities(N2, K2, cityList2);
        System.out.println(String.join(" ", topCities2)); // Output: Bangalore

        // Example 3
        // Input: 4 4
        // Jaipur 40
        // Agra 38
        // Varanasi 39
        // Lucknow 37
        // Expected Output: Jaipur Varanasi Agra Lucknow
        List<Map.Entry<String, Integer>> cityList3 = new ArrayList<>();
        cityList3.add(new AbstractMap.SimpleEntry<>("Jaipur", 40));
        cityList3.add(new AbstractMap.SimpleEntry<>("Agra", 38));
        cityList3.add(new AbstractMap.SimpleEntry<>("Varanasi", 39));
        cityList3.add(new AbstractMap.SimpleEntry<>("Lucknow", 37));

        int N3 = cityList3.size();
        int K3 = 4;

        List<String> topCities3 = topKCities(N3, K3, cityList3);
        System.out.println(String.join(" ", topCities3)); // Output: Jaipur Varanasi Agra Lucknow
    }
}