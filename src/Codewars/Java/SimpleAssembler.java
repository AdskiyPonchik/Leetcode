package Codewars.Java;

import java.util.HashMap;
import java.util.Map;

public class SimpleAssembler {
    public static Map<String, Integer> interpret(String[] program) {
        Map<String, Integer> registers = new HashMap<>();
        int ip = 0;
        while (ip < program.length) {
            String[] tokens = program[ip].split(" ");
            String command = tokens[0];
            switch (command) {
                case "mov":
                    registers.put(tokens[1], getValue(tokens[2], registers));
                    ip++;
                    break;
                case "inc":
                    registers.put(tokens[1], registers.getOrDefault(tokens[1], 0) + 1);
                    ip++;
                    break;
                case "dec":
                    registers.put(tokens[1], registers.getOrDefault(tokens[1], 0) - 1);
                    ip++;
                    break;
                case "jnz":
                    int valueX = getValue(tokens[1], registers);
                    int valueY = getValue(tokens[2], registers);
                    if (valueX != 0) {
                        ip += valueY;
                    } else {
                        ip++;
                    }
                default:
                    break;
            }
        }
        return registers;
    }


    private static int getValue(String arg, Map<String, Integer> registers) {
        if (Character.isLetter(arg.charAt(0))) {
            return registers.getOrDefault(arg, 0);
        }

        return Integer.parseInt(arg);
    }

    public static void main(String[] args) {
        String[] program = new String[]{"mov a -10", "mov b a", "inc a", "dec b", "jnz a -2"};
        Map<String, Integer> out = new HashMap<String, Integer>();
        out.put("a", 0);
        out.put("b", -20);
        System.out.printf("%s must be %s", out, SimpleAssembler.interpret(program));
    }
}