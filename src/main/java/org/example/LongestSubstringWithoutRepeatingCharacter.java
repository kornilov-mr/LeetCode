package org.example;


import java.util.HashMap;
import java.util.Map;

/**
 * Longest Substring Without Repeating Characters
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/description/">...</a>
 */
public class LongestSubstringWithoutRepeatingCharacter {

    private static final Map<Character, Integer> charMap = new HashMap<>();

    public static int lengthOfLongestSubstring(String s) {

        int max = 0;
        int l = 0;
        int r = 0;
        while (r>=l && r<s.length()) {
            int charValue = charMap.getOrDefault(s.charAt(r), 0);
            if (charValue == 0){
                charMap.put(s.charAt(r), 1);
                r++;
            }
            if (charValue == 1){
                charMap.put(s.charAt(l), 0);
                l++;
            }
            max = Math.max(max, r-l);
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring( "bbbbb"));
    }
}
