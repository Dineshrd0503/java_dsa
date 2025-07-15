package logicwhilearrays;

import java.util.Arrays;
import java.util.HashMap;

public class EqualArraysBasedonFrequency {
    public static void main(String[] args) {
        int[] a={3,1,2};
        int[] b={2,1,3};
        System.out.println("counting freq of eahc element in each array");

        System.out.println(areEqualArrays(a,b)?"Equal":"Not equal");



    }

    public static boolean areEqualArrays(int[] a, int[] b) {
        int[] freq=new int[10];
        for(int i:a)
            freq[i]++;

        for(int i:b)
            freq[i]--;

        for(int i:freq){
            if(i!=0) return false;

        }
        return true;
    }
}
