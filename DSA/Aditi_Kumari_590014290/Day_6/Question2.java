package Day_6;

import java.util.*;

public class Question2 {
    public ArrayList<Integer> union(int[] arr1, int[] arr2){
        TreeSet <Integer> set= new TreeSet<>();
        for (int num:arr1){
            set.add(num);
        }
        for(int num: arr2){
            set.add(num);
        }
        return new ArrayList<>(set);
    }
}
