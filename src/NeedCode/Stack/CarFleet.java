package NeedCode.Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeMap;

public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Double> map = new TreeMap<>();
        Deque<Double> stack = new ArrayDeque<>();
        for(int i = 0; i < position.length; i++){
            int pos = position[i];
            map.put(pos, (double)(target-pos)/speed[i]);
        }
        for(double time : map.descendingMap().values()){
            if(stack.isEmpty() || stack.getFirst() < time){
                stack.push(time);
            }
        }
        return stack.size();
    }
}
