package codingninjas;

import java.util.HashMap;
import java.util.Map;

public class MinMaxFreqEles {

        public static int[] getFrequencies(int[] v) {
            int maxele = Integer.MIN_VALUE, minele = Integer.MAX_VALUE;
            int maxfreq = Integer.MIN_VALUE, minfreq = Integer.MAX_VALUE;
            Map<Integer, Integer> map = new HashMap<>();

            // Count the frequency of each element
            for (int n : v) {
                map.put(n, map.getOrDefault(n, 0) + 1);
            }

            // Traverse the map to determine maxfreq and minfreq
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int ele = entry.getKey(), freq = entry.getValue();

                // Update maxfreq and maxele
                if (freq > maxfreq || (freq == maxfreq && ele < maxele)) {
                    maxfreq = freq;
                    maxele = ele;
                }

                // Update minfreq and minele
                if (freq < minfreq || (freq == minfreq && ele < minele)) {
                    minfreq = freq;
                    minele = ele;
                }
            }

            return new int[]{maxele, minele};
        }

        public static void main(String[] args) {
            int[] v = {1, 2,2, 2, 3, 4, 4, 4, 5, 5, 5};
            int[] result = getFrequencies(v);
            System.out.println("Max element: " + result[0]);
            System.out.println("Min element: " + result[1]);
        }
    }
