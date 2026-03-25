package Codewars.Java;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
// foo099 -> foo100
public class StringIncrementer {

    private static final Pattern PATTERN = Pattern.compile("^(.*?)(\\d*)$");

    public static String incrementString(String str) {
        Matcher matcher = PATTERN.matcher(str);
        if (!matcher.find()) return str + "1";
        String text = matcher.group(1);
        String digits = matcher.group(2);

        if (digits.isEmpty()) {
            return text + "1";
        }

        BigInteger number = new BigInteger(digits).add(BigInteger.ONE);
        String incremented = number.toString();
        int padding = digits.length() - incremented.length();

        return text + (padding > 0 ? "0".repeat(padding) : "") + incremented;
    }

    public static void main(String[] args){
        System.out.println(incrementString("foo099"));
    }
}
