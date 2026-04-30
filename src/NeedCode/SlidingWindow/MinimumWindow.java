package NeedCode.SlidingWindow;

public class MinimumWindow {
    public String minWid(String s, String t){
        if(t.isEmpty() || s.isEmpty()){
            return "";
        }
        int[] arr = new int[128];
        int tCount = 0;
        for(char c: t.toCharArray()){
            arr[c]+=1;
            if(arr[c]==1){
                tCount++;
            }
        }
        int left = 0;
        int right = 0;
        int[] window = new int[128];
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;
        int count = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            window[c]++;
            if(arr[c] == window[c]){
                count++;
            }
            while(count == tCount){
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    startIndex = left;
                }
                char leftChar = s.charAt(left);
                if (arr[leftChar] > 0 && window[leftChar] == arr[leftChar]) {
                    count--;
                }
                window[leftChar]--;
                left++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex+minLength);
    }
}
