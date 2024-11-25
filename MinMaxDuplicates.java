import java.util.*;  

public class MinMaxDuplicates {  
    public static void main(String[] args) {  
        List<Integer> list = Arrays.asList(1, 2, 3, 2, 4, 5, 1, 6, 3, 3);  
        
        // Step 1: Count occurrences  
        Map<Integer, Integer> countMap = new HashMap<>();  
        for (int num : list) {  
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);  
        }  

        // Step 2: Identify duplicates  
        List<Integer> duplicates = new ArrayList<>();  
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {  
            if (entry.getValue() > 1) {  
                duplicates.add(entry.getKey());  
            }  
        }  

        // Step 3: Find min and max of duplicates  
        if (!duplicates.isEmpty()) {  
            int minDuplicate = Collections.min(duplicates);  
            int maxDuplicate = Collections.max(duplicates);  
            System.out.println("Minimum duplicate: " + minDuplicate);  
            System.out.println("Maximum duplicate: " + maxDuplicate);  
        } else {  
            System.out.println("No duplicates found.");  
        }  
    }  
}