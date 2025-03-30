package greedyalgorithms;

//There are some gas stations along a circular route. You are given two integer arrays gas[] denoted as the amount of gas present at each station and cost[] denoted as the cost of travelling to the next station. You have a car with an unlimited gas tank. You begin the journey with an empty tank from one of the gas stations. Return the index of the starting gas station if it's possible to travel around the circuit without running out of gas at any station in a clockwise direction. If there is no such starting station exists, return -1.
//Note: If a solution exists, it is guaranteed to be unique.
//
//        Examples:
//
//Input: gas[] = [4, 5, 7, 4], cost[]= [6, 6, 3, 5]
//Output: 2
//Explanation: It is possible to travel around the circuit from station at index 2. Amount of gas at station 2 is (0 + 7) = 7.
//Travel to station 3. Available gas = (7 – 3 + 4) = 8.
//Travel to station 0. Available gas = (8 – 5 + 4) = 7.
//Travel to station 1. Available gas = (7 – 6 + 5) = 6.
//Return to station 2. Available gas = (6 – 6) = 0.
//Input: gas[] = [1, 2, 3, 4, 5], cost[] = [3, 4, 5, 1, 2]
//Output: 3
//Explanation: It is possible to travel around the circuit from station at index 3. Amount of gas at station 3 is (0 + 4) = 4.
//Travel to station 4. Available gas = 4 – 1 + 5 = 8.
//Travel to station 0. Available gas = 8 – 2 + 1 = 7.
//Travel to station 1. Available gas= 7 – 3 + 2 = 6.
//Travel to station 2. Available gas = 6 – 4 + 3 = 5.
//Travel to station 3. The cost is 5. The gas is just enough to travel back to station 3.
//Input: gas[] = [3, 9], cost[] = [7, 6]
//Output: -1
//Explanation: There is no gas station to start with such that you can complete the circuit.
//        Constraints:
//        1 ≤ gas.size(), cost.size() ≤ 106
//        1 ≤ gas[i], cost[i] ≤ 103


import java.util.Arrays;

public class GasSelecttions {
    public int startStation(int[] gas, int[] cost) {
        // Your code here
        int totalgas= Arrays.stream(gas).sum();
        int totalcost=Arrays.stream(cost).sum();
        if(totalgas<totalcost) return -1;
        int start=0,currgas=0;
        for(int i=0;i<gas.length;i++){
            currgas+=gas[i]-cost[i];
            if(currgas<0){
                start=i+1;
                currgas=0;
            }
        }
        return start;

    }
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        GasSelecttions obj=new GasSelecttions();
        System.out.println(obj.startStation(gas,cost));
    }
}
