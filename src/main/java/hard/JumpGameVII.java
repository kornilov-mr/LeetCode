package hard;

/**
 * Jump Game VII
 * <a href="https://leetcode.com/problems/jump-game-vii/description/">...</a>
 */
public class JumpGameVII {
    public static int[] dp;
    public static boolean canReach(String s, int minJump, int maxJump) {
        dp = new int[s.length()];
        dp[0] = 1;
        for(int i =0; i<s.length(); i++){
            if(s.charAt(i) == '1')
                continue;
            for(int j= Math.max(0, i-maxJump); j<=Math.min(s.length()-1, i+minJump); j++){
                if(dp[j]==1){
                    dp[i]=1;
                    break;
                }
            }
        }
        return dp[s.length() - 1] == 1;
    }

    public static void main(String[] args) {
        System.out.println(canReach("011010",2,3));
    }
}
