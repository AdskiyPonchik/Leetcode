package NeedCode.SlidingWindow;

public class CharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] arr =new int[26];
        int max_freq = 0;
        int result = 0;
        int r = 0, l = 0;
        while(r < s.length()){
            int currentIndex = s.charAt(r) - 'A';
            arr[currentIndex]++;
            max_freq = Math.max(max_freq, arr[currentIndex]);
           if((r-l + 1) - max_freq > k){
               arr[s.charAt(l) - 'A'] -=1;
               l++;
           }
           result = Math.max(result, r-l+1);
           r++;
        }
        return result;
    }
}
