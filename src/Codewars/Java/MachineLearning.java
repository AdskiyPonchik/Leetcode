package Codewars.Java;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

// Task is extremely difficult to understand, but since you're done with it, it's elementary to solve

public class MachineLearning {

    private final Map<Integer, Integer> solutions = new HashMap<>();
    private final Map<Integer, Integer> currentTrial= new HashMap<>();
    private int lastCmd;
    private int lastIdx;
    List<Function<Integer, Integer>> actions = List.of(
            n -> n + 1,
            n -> n - 1,
            n -> n * 2,
            n -> n / 2,
            n -> n * 100,
            n -> n % 2,
            n -> n / 10,
            n -> n * n,
            n -> (int) Math.sqrt(n),
            n -> 0,
            n -> 1,
            n -> 2,
            n -> 3,
            n -> 4,
            n -> 5,
            n -> 100
    );

    public int command(int cmd, int num) {
        this.lastCmd = cmd;
        if (solutions.containsKey(cmd)) {
            this.lastIdx = solutions.get(cmd);
        } else {
            this.lastIdx = currentTrial.getOrDefault(cmd, 0);
        }
        return actions.get(this.lastIdx).apply(num);
    }

    public void response(boolean result) {
        if(result){
            solutions.put(lastCmd, lastIdx);
        }else{
            solutions.remove(lastCmd);
            currentTrial.put(lastCmd, lastIdx + 1);
        }
    }
}
