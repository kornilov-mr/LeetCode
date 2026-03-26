package easy;

/**
 * Score of the String
 * <a href="https://leetcode.com/problems/score-of-a-string/description/">...</a>
 */
public class ScoreOfTheString {
    public int scoreOfString(String s) {
        int result=0;
        for(int i =0; i<s.length()-1; i++){
            result += Math.abs((int)s.charAt(i) - (int)s.charAt(i+1));
        }
        return result;
    }
}
