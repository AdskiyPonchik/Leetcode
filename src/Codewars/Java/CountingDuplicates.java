package Codewars.Java;

import java.util.Map;
import java.util.stream.Collectors;

public class CountingDuplicates {
    public static int duplicateCount(String text) {
        Map<Integer, Long> map = text.toLowerCase()
                .chars().boxed()
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        return (int)map.values().stream().filter(count -> count>1).count();
    }
}
