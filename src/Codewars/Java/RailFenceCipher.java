package Codewars.Java;

import static org.junit.Assert.assertEquals;

public class RailFenceCipher {
    static String encode(String s, int n) {
        if (s.isEmpty() || n <= 1) {
            return s;
        }
        StringBuilder[] rails = new StringBuilder[n];
        for (int i = 0; i < n; i++) {
            rails[i] = new StringBuilder();
        }
        int currentRail = 0;
        boolean movingDown = true;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            rails[currentRail].append(ch);
            if (movingDown == true) {
                currentRail++;
            } else {
                currentRail--;
            }
            if (currentRail == n - 1) {
                movingDown = false;
            } else if (currentRail == 0) {
                movingDown = true;
            }
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder rail : rails) {
            result.append(rail);
        }
        return result.toString();
    }

    static String decode(String s, int n) {
        if (s.isEmpty() || n <= 1) {
            return s;
        }
        StringBuilder[] rails = new StringBuilder[n];
        int[] railLengths = new int[n];
        for (int i = 0; i < n; i++) {
            rails[i] = new StringBuilder();
        }
        int currentRail = 0;
        boolean movingDown = true;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            railLengths[currentRail]++;
            if (movingDown == true) {
                currentRail++;
            } else {
                currentRail--;
            }
            if (currentRail == n - 1) {
                movingDown = false;
            } else if (currentRail == 0) {
                movingDown = true;
            }
        }
        int currIdx = 0;
        for (int i = 0; i < n; i++) {
            int length = railLengths[i];
            String railContent = s.substring(currIdx, currIdx + length);
            rails[i] = new StringBuilder(railContent);
            currIdx += length;
        }

        StringBuilder result = new StringBuilder();
        currentRail = 0;
        movingDown = true;

        for (int i = 0; i < s.length(); i++) {
            char ch = rails[currentRail].charAt(0);
            result.append(ch);

            rails[currentRail].deleteCharAt(0);

            if (movingDown) {
                currentRail++;
            } else {
                currentRail--;
            }

            if (currentRail == n - 1) {
                movingDown = false;
            } else if (currentRail == 0) {
                movingDown = true;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String[][] encodes = {{"WEAREDISCOVEREDFLEEATONCE", "WECRLTEERDSOEEFEAOCAIVDEN"},  // 3 rails
                {"Hello, World!", "Hoo!el,Wrdl l"},    // 3 rails
                {"Hello, World!", "H !e,Wdloollr"},    // 4 rails
                {"", ""}                               // 3 rails (even if...)
        };
        int[] rails = {3, 3, 4, 3};
        for (int i = 0; i < encodes.length; i++) {
            System.out.printf("%s must be %s\n", encodes[i][1], RailFenceCipher.encode(encodes[i][0], rails[i]));
        }

        String[][] decodes = {{"WECRLTEERDSOEEFEAOCAIVDEN", "WEAREDISCOVEREDFLEEATONCE"},    // 3 rails
                {"H !e,Wdloollr", "Hello, World!"},    // 4 rails
                {"", ""}                               // 3 rails (even if...)
        };
        int[] rails_1 = {3, 4, 3};
        for (int i = 0; i < decodes.length; i++) {
            System.out.printf("%s must be %s\n", decodes[i][1], RailFenceCipher.decode(decodes[i][0], rails_1[i]));
        }
    }
}
