package Leetcode;

//Difficulty: Easy

//Bad solution?

public class AreNumbersAscending {
    public boolean areNumbersAscending(String s){
        String[] findString = s.split("\\s+");
        int prevnum = 0;
        for(String t: findString){
            if(t.matches("\\d+")){
                int newnum = Integer.parseInt(t);
                if(newnum<=prevnum)return false;
                prevnum = newnum;
            }
        }
        return true;
    }
}
