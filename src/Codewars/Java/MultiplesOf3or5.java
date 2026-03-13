package Codewars.Java;

import java.util.stream.IntStream;

public class MultiplesOf3or5 {
    public static int solution(int number) {
//        int result = 0;
//        for(int i = 0; i < number; i++){
//            if(i%3==0 || i%5==0){
//                result+=i;
//            }
//        }
        return IntStream.range(0, number).filter(x -> x%5==0 || x%3==0).sum();
    }

    public static void main(String[] args){
        System.out.println(solution(10));
    }
}
