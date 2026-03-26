package normal;

/**
 * 5. Longest Palindromic Substring
 * <a href="https://leetcode.com/problems/longest-palindromic-substring/">...</a>
 */
public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        int left = 0;
        int right = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int odd = expandAroundMiddle(i, i, s);
            int even = expandAroundMiddle(i, i + 1, s);
            int currMaxLen = Math.max(odd, even);
            if (currMaxLen > maxLen) {
                left = i - ((currMaxLen - 1) / 2);
                right = i + ((currMaxLen) / 2);
                maxLen = currMaxLen;
            }
        }
        return s.substring(left, right + 1);
    }

    private static int expandAroundMiddle(int left, int right, String s) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }
}
