package Codewars.Java;

public class TimeFormatter {
    // EXAMPLE: "1 hour, 1 minute and 2 seconds"

    public static String formatDuration(int seconds) {
        if (seconds == 0) {
            return "now";
        }
        int counter = 0;
        int[] data = new int[5];
        int[] dividors = new int[]{31536000, 86400, 3600, 60, 1};
        String[] words = {"year", "day", "hour", "minute", "second"};
        for (int i = 0; i < dividors.length; i++) {
            data[i] = seconds / dividors[i];
            seconds %= dividors[i];
            if (data[i] != 0) {
                counter++;
            }

        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            if (data[i] == 0) continue;
            result.append(data[i]).append(" ").append(words[i]);
            if (data[i] > 1) {
                result.append("s");
            }
            counter--;
            if(counter > 1){
                result.append(", ");
            }else if(counter==1){
                result.append(" and ");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(formatDuration(3599));
    }
}