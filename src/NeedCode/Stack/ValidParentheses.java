package NeedCode.Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> samples = new HashMap<>();
        samples.put(')', '(');
        samples.put('}', '{');
        samples.put(']', '[');
        for (char c : s.toCharArray()) {
            if (samples.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != samples.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        ValidParentheses test = new ValidParentheses();
        System.out.println(test.isValid("[]") + "<--- True");
        System.out.println(test.isValid("([{}])") + "<--- True");
        System.out.println(test.isValid("[(])") + "<--- False");
        System.out.println(test.isValid("[") + "<--- False");
    }
}
