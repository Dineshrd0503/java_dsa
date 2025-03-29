package greedyalgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

//You are given two arrays: deadline[], and profit[], which represent a set of jobs, where each job is associated with a deadline, and a profit. Each job takes 1 unit of time to complete, and only one job can be scheduled at a time. You will earn the profit associated with a job only if it is completed by its deadline.
//
//Your task is to find:
//
//The maximum number of jobs that can be completed within their deadlines.
//The total maximum profit earned by completing those jobs.
//        Examples :
//
//Input: deadline[] = [4, 1, 1, 1], profit[] = [20, 10, 40, 30]
//Output: [2, 60]
//Explanation: Job1 and Job3 can be done with maximum profit of 60 (20+40).
//Input: deadline[] = [2, 1, 2, 1, 1], profit[] = [100, 19, 27, 25, 15]
//Output: [2, 127]
//Explanation: Job1 and Job3 can be done with maximum profit of 127 (100+27).
//Input: deadline[] = [3, 1, 2, 2], profit[] = [50, 10, 20, 30]
//Output: [3, 100]
//Explanation: Job1, Job3 and Job4 can be completed with a maximum profit of 100 (50 + 20 + 30).
//Constraints:
//        1 ≤ deadline.size() == profit.size() ≤ 105
//        1 ≤ deadline[i] ≤ deadline.size()
//1 ≤ profit[i] ≤ 500


public class JobScheduling {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        int n=deadline.length;
        Job[] jobs=new Job[n];
        for(int i=0;i<n;i++)
            jobs[i]=new Job(deadline[i],profit[i]);
        Arrays.sort(jobs, Comparator.comparingInt((Job j)-> -j.profit));
        boolean[] slots=new boolean[n];
        int count=0,totalprofit=0;
        for(Job job:jobs){
            for(int j=Math.min(n,job.deadline)-1;j>=0;j--){
                if(!slots[j]){
                    slots[j]=true;
                    count++;
                    totalprofit+=job.profit;
                    break;
                }
            }

        }
        ArrayList<Integer> result=new ArrayList<>();
        result.add(count);
        result.add(totalprofit);
        return result;


    }
    private static class Job{
        int deadline;
        int profit;
        Job(int deadline,int profit){
            this.deadline=deadline;
            this.profit=profit;
        }
    }

    public static void main(String[] args) {
        JobScheduling jobScheduling=new JobScheduling();
        int[] deadline={2,1,2,1,3};
        int[] profit={100,19,27,25,15};
        ArrayList<Integer> result=jobScheduling.jobSequencing(deadline,profit);
        System.out.println("Number of jobs: "+result.get(0));
        System.out.println("Total profit: "+result.get(1));
    }
}
