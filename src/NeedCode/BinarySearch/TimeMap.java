package NeedCode.BinarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TimeMap {
    private Map<String, List<Entry>> map = new HashMap<>();
    private record Entry(int timestamp, String value) {

    }

    public TimeMap() {
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, v -> new ArrayList<>())
                .add(new Entry(timestamp, value));
    }

    public String get(String key, int timestamp) {
        List<Entry> data = map.get(key);
        if(data == null || data.isEmpty() || timestamp < data.get(0).timestamp()){
            return "";
        }
        int left = 0, right = data.size()-1 ;
        String result = "";
        while(left <= right){
            int mid = left + (right -left)/2;
            if(data.get(mid).timestamp() <= timestamp){
                result = data.get(mid).value();
                left= mid+1;
            }else{
                right = mid-1;
            }
        }
        return result;
    }
}
