package Codewars.Java;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateEncoder {
    //( - symbol
    static String encoder(String word){
        word = word.toLowerCase();
        Map<Character, Long> map = word.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        StringBuilder result = new StringBuilder();
        for(char c: word.toCharArray()){
            if(map.get(c)>1){
                result.append(')');
            }else{
                result.append('(');
            }
        }
        return result.toString();
    }

    public static void main(String[] args){
        assert encoder("din").equals("(((");
        assert encoder("recede").equals("()()()");
        assert encoder("(( @").equals("))( (");
    }
}
