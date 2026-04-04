package normal;

/**
 * Longest Increasing Subsequence
 * <a href="https://leetcode.com/problems/longest-increasing-subsequence/description/">...</a>
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return 1;
        dp[nums.length-1]=1;
        for(int i=nums.length-2;i>=0;i--){
            int maxSeq = 1;
            for(int j = i+1;j<nums.length;j++){
                if(nums[i]>=nums[j])
                    continue;
                maxSeq = Math.max(maxSeq,dp[j]+1);
            }
            dp[i] = maxSeq;
        }
        int max=0;
        for(int d: dp){
            max=Math.max(max,d);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence cl = new LongestIncreasingSubsequence();
        System.out.println(cl.lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
    }
}
