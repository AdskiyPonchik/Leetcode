package Codewars.Java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Meeting {
    record Person(String firstName, String lastName){};
    public static String meeting(String s) {
        String[] splittedString = s.toUpperCase().split(";");
        return Arrays.stream(splittedString)
                .map(x -> x.split(":"))
                .map(parts -> new Person(parts[0], parts[1]))
                .sorted(Comparator.comparing(Person::lastName).thenComparing(Person::firstName))
                .map(p -> "(" + p.lastName() + ", " + p.firstName() + ")")
                .collect(Collectors.joining());
    }
}
