package Codewars.Java;

import java.util.HashMap;
import java.util.Map;

public class TCP {
    private static final Map<String, Map<String, String>> TRANSITIONS = new HashMap<>();

    static {
        TRANSITIONS.put("CLOSED",      Map.of("APP_PASSIVE_OPEN", "LISTEN", "APP_ACTIVE_OPEN", "SYN_SENT"));
        TRANSITIONS.put("LISTEN",      Map.of("RCV_SYN", "SYN_RCVD", "APP_SEND", "SYN_SENT", "APP_CLOSE", "CLOSED"));
        TRANSITIONS.put("SYN_RCVD",    Map.of("APP_CLOSE", "FIN_WAIT_1", "RCV_ACK", "ESTABLISHED"));
        TRANSITIONS.put("SYN_SENT",    Map.of("RCV_SYN", "SYN_RCVD", "RCV_SYN_ACK", "ESTABLISHED", "APP_CLOSE", "CLOSED"));
        TRANSITIONS.put("ESTABLISHED", Map.of("APP_CLOSE", "FIN_WAIT_1", "RCV_FIN", "CLOSE_WAIT"));
        TRANSITIONS.put("FIN_WAIT_1",  Map.of("RCV_FIN", "CLOSING", "RCV_FIN_ACK", "TIME_WAIT", "RCV_ACK", "FIN_WAIT_2"));
        TRANSITIONS.put("CLOSING",     Map.of("RCV_ACK", "TIME_WAIT"));
        TRANSITIONS.put("FIN_WAIT_2",  Map.of("RCV_FIN", "TIME_WAIT"));
        TRANSITIONS.put("CLOSE_WAIT",  Map.of("APP_CLOSE", "LAST_ACK"));
        TRANSITIONS.put("LAST_ACK",    Map.of("RCV_ACK", "CLOSED"));
        TRANSITIONS.put("TIME_WAIT",   Map.of("APP_TIMEOUT", "CLOSED"));
    }
    public static String traverseStates(String[] events) {
        String currentState = "CLOSED";
        for(String e: events){
            Map<String, String> availableEvents = TRANSITIONS.get(currentState);
            if (availableEvents == null || !availableEvents.containsKey(e)) {
                return "ERROR";
            }
            currentState = availableEvents.get(e);
        }
        return currentState;
    }
}