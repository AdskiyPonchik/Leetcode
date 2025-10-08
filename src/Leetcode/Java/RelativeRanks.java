package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Difficulty: Easy

public class RelativeRanks {
    public String[] findRelativeRanks(int[] score){
        Map<Integer, Integer> hashtable = new HashMap<>();
        String[] result = new String[score.length];
        for(int i = 0; i< score.length; i++){
            hashtable.put(score[i], i);
        }
        Arrays.sort(score);
        for(int i = 0; i < score.length; i++){
            int index = hashtable.get(score[i]);
            if(i == score.length-1){
                result[index] = "Gold Medal";
            }else if(i==score.length-2){
                result[index] = "Silver Medal";
            }else if(i==score.length-3){
                result[index] = "Bronze Medal";
            }else{
                result[index] = String.valueOf(score.length-i);
            }
        }
        return result;
    }
}
