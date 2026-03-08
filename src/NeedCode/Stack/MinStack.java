package NeedCode.Stack;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Objects;


class MinStack {
    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> minStory = new ArrayDeque<>();
    public MinStack() {
    }

    public void push(int val) {
        stack.push(val);
        if(minStory.isEmpty() || val <= minStory.getFirst()){
            minStory.push(val);
        }
    }
    public void pop() {
        if (Objects.equals(stack.getFirst(), minStory.getFirst())) {
            minStory.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.getFirst();
    }

    public int getMin() {
        return minStory.getFirst();
    }
}

