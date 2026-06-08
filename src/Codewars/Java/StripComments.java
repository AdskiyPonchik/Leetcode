package Codewars.Java;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StripComments {
    public static String stripComments(String text, String[] commentSymbols) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        String markersPattern = Arrays.stream(commentSymbols)
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));

        if (markersPattern.isEmpty()) {
            return text;
        }
        String regex = "(?m)[ \\t]*(?:" + markersPattern + ").*|[ \\t]+$";
        return text.replaceAll(regex, "");
    }

    public static String stripComments_alt(String text, String[] commentSymbols) {
        String pattern = String.format(
                "[ ]*([%s].*)?$",
                Arrays.stream( commentSymbols ).collect( Collectors.joining() )
        );
        return Arrays.stream( text.split( "\n" ) )
                .map( x -> x.replaceAll( pattern, "" ) )
                .collect( Collectors.joining( "\n" ) );
    }

    public static void main(String[] args) {
        System.out.printf("%s\nmust be\n%s",
                "apples, pears\ngrapes\nbananas",
                StripComments.stripComments("apples, pears # and bananas\ngrapes\nbananas !apples", new String[]{"#", "!"})
        );
    }
}
