package Leetcode;

//Difficulty: Easy

public class ArrangeCoins {
    public int arrangeCoins(int n){
        int counter = 0;
        while(counter<=n){
            n-=counter;
            counter++;
        }
        return counter-1;
    }
}
