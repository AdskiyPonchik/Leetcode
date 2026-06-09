package Codewars.Java.Bosses;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class AssemblerInterpreter {

    public static class ExecutionContext {
        public final Map<String, Integer> registers = new HashMap<>();
        public final Stack<Integer> callStack = new Stack<>();
        public final StringBuilder output = new StringBuilder();
        public int ip = 0;
        public int cmpResult = 0;
        public boolean hasEnded = false;
    }

    @FunctionalInterface
    private interface CommandAction {
        void execute(ExecutionContext ctx, String[] args, Map<String, Integer> labels);
    }

    private static final Map<String, CommandAction> COMMANDS = new HashMap<>();

    public static String interpret(final String input) {
        if (input == null || input.isEmpty()) return null;

        String[] programLines = input.split("\\r?\\n");
        Map<String, Integer> labels = new HashMap<>();
        List<String> cleanProgram = firstPass(programLines, labels);

        ExecutionContext ctx = new ExecutionContext();
        while (ctx.ip < cleanProgram.size() && !ctx.hasEnded) {
            String line = cleanProgram.get(ctx.ip);
            String[] parts = line.split("\\s+", 2);
            String cmdName = parts[0];

            String[] args = new String[0];
            if (parts.length > 1) {
                if (cmdName.equals("msg")) {
                    args = parseMsgArgs(line).toArray(new String[0]);
                } else {
                    args = Arrays.stream(parts[1].split(","))
                            .map(String::trim)
                            .toArray(String[]::new);
                }
            }
            CommandAction command = COMMANDS.get(cmdName);
            if (command != null) {
                command.execute(ctx, args, labels);
            } else {
                ctx.ip++;
            }
        }

        return ctx.hasEnded ? ctx.output.toString() : null;
    }

    static {
        COMMANDS.put("mov", (ctx, args, labels) -> {
            ctx.registers.put(args[0], getValue(args[1], ctx.registers));
            ctx.ip++;
        });

        COMMANDS.put("inc", (ctx, args, labels) -> {
            ctx.registers.put(args[0], ctx.registers.getOrDefault(args[0], 0) + 1);
            ctx.ip++;
        });

        COMMANDS.put("dec", (ctx, args, labels) -> {
            ctx.registers.put(args[0], ctx.registers.getOrDefault(args[0], 0) - 1);
            ctx.ip++;
        });

        COMMANDS.put("add", (ctx, args, labels) -> {
            ctx.registers.put(args[0], getValue(args[0], ctx.registers) + getValue(args[1], ctx.registers));
            ctx.ip++;
        });

        COMMANDS.put("sub", (ctx, args, labels) -> {
            ctx.registers.put(args[0], getValue(args[0], ctx.registers) - getValue(args[1], ctx.registers));
            ctx.ip++;
        });

        COMMANDS.put("mul", (ctx, args, labels) -> {
            ctx.registers.put(args[0], getValue(args[0], ctx.registers) * getValue(args[1], ctx.registers));
            ctx.ip++;
        });

        COMMANDS.put("div", (ctx, args, labels) -> {
            ctx.registers.put(args[0], getValue(args[0], ctx.registers) / getValue(args[1], ctx.registers));
            ctx.ip++;
        });

        COMMANDS.put("end", (ctx, args, labels) -> {
            ctx.hasEnded = true;
        });

        COMMANDS.put("msg", (ctx, args, labels) -> {
            for (String arg : args) {
                if (arg.startsWith("'") && arg.endsWith("'")) {
                    ctx.output.append(arg.substring(1, arg.length() - 1));
                } else {
                    ctx.output.append(getValue(arg, ctx.registers));
                }
            }
            ctx.ip++;
        });

        COMMANDS.put("cmp", (ctx, args, labels) -> {
            int x = getValue(args[0], ctx.registers);
            int y = getValue(args[1], ctx.registers);
            ctx.cmpResult = Integer.compare(x, y);
            ctx.ip++;
        });

        COMMANDS.put("jmp", (ctx, args, labels) -> {
            ctx.ip = labels.get(args[0]);
        });

        COMMANDS.put("je", (ctx, args, labels) -> {
            if (ctx.cmpResult == 0) ctx.ip = labels.get(args[0]);
            else ctx.ip++;
        });

        COMMANDS.put("jne", (ctx, args, labels) -> {
            if (ctx.cmpResult != 0) ctx.ip = labels.get(args[0]);
            else ctx.ip++;
        });

        COMMANDS.put("jg", (ctx, args, labels) -> {
            if (ctx.cmpResult > 0) ctx.ip = labels.get(args[0]);
            else ctx.ip++;
        });

        COMMANDS.put("jge", (ctx, args, labels) -> {
            if (ctx.cmpResult >= 0) ctx.ip = labels.get(args[0]);
            else ctx.ip++;
        });

        COMMANDS.put("jl", (ctx, args, labels) -> {
            if (ctx.cmpResult < 0) ctx.ip = labels.get(args[0]);
            else ctx.ip++;
        });

        COMMANDS.put("jle", (ctx, args, labels) -> {
            if (ctx.cmpResult <= 0) ctx.ip = labels.get(args[0]);
            else ctx.ip++;
        });

        COMMANDS.put("call", (ctx, args, labels) -> {
            ctx.callStack.push(ctx.ip + 1);
            ctx.ip = labels.get(args[0]);
        });

        COMMANDS.put("ret", (ctx, args, labels) -> {
            ctx.ip = ctx.callStack.pop();
        });

    }

    private static List<String> firstPass(String[] program, Map<String, Integer> labels) {
        List<String> cleanProgram = new ArrayList<>();
        for (String line : program) {
            String stripped = removeComment(line).trim();
            if (stripped.isEmpty()) continue;

            if (stripped.contains(":")) {
                int colonIdx = stripped.indexOf(":");
                String possibleLabel = stripped.substring(0, colonIdx).trim();
                if (possibleLabel.matches("[a-zA-Z_][a-zA-Z0-9_]*")) {
                    labels.put(possibleLabel, cleanProgram.size());
                    String remainder = stripped.substring(colonIdx + 1).trim();
                    if (!remainder.isEmpty()) cleanProgram.add(remainder);
                    continue;
                }
            }
            cleanProgram.add(stripped);
        }
        return cleanProgram;
    }

    private static boolean isValidLabel(String s) {
        return s.matches("[a-zA-Z_][a-zA-Z0-9_]*");
    }

    private static String removeComment(String line) {
        int semiColonIdx = line.indexOf(';');
        if (semiColonIdx != -1) {
            if (!line.contains("msg")) return line.substring(0, semiColonIdx);
            boolean inQuotes = false;
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '\'') inQuotes = !inQuotes;
                if (line.charAt(i) == ';' && !inQuotes) return line.substring(0, i);
            }
        }
        return line;
    }

    private static List<String> parseMsgArgs(String msgLine) {
        List<String> args = new ArrayList<>();
        int msgIdx = msgLine.indexOf("msg");
        String content = msgLine.substring(msgIdx + 3).trim();
        Pattern pattern = Pattern.compile("'[^']*'|[^, \\t]+");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            args.add(matcher.group());
        }
        return args;
    }

    private static String cleanArg(String part) {
        return part.replace(",", "").trim();
    }

    private static int getValue(String arg, Map<String, Integer> registers) {
        if (Character.isLetter(arg.charAt(0)) || arg.charAt(0) == '_') {
            return registers.getOrDefault(arg, 0);
        }
        return Integer.parseInt(arg);
    }

}
