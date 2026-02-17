package NeedCode.SlidingWindow;

import java.util.Arrays;

public class CheckInclusion {
    public static boolean checkInclusion(String s1, String s2) {
        int s1Length = s1.length();
        int s2Length = s2.length();
        if(s1Length > s2Length)return false;
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for(int i = 0; i < s1Length; i++){
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(arr1, arr2)) return true;
        for(int i = s1Length; i < s2Length; i++){
            arr2[s2.charAt(i) - 'a']++;
            arr2[s2.charAt(i-s1Length)-'a']--;
            if (Arrays.equals(arr1, arr2)) return true;
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println(checkInclusion( "abc", "lecabee"));
    }

}
