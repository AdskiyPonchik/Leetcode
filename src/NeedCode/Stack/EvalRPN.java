package NeedCode.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String t : tokens) {
            switch (t) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "-" -> {
                    int b = stack.pop();
                    stack.push(stack.pop() - b);
                }
                case "/" -> {
                    int b = stack.pop();
                    stack.push(stack.pop() / b);
                }
                default -> stack.push(Integer.parseInt(t));
            }
        }
        return stack.pop();
    }


    public static void main(String[] args){
        EvalRPN test = new EvalRPN();
        String[] tokens = new String[]{"1","2","+","3","*","4","-"};
        System.out.println(test.evalRPN(tokens));
    }
}
