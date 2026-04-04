package normal;

/**
 * Number of Longest Increasing Subsequence
 * <a href="https://leetcode.com/problems/number-of-longest-increasing-subsequence/solutions/3588849/number-of-longest-increasing-subsequence-v9pr/">...</a>
 */
public class NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] dpCount = new int[nums.length];
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return 1;
        dp[nums.length-1]=1;
        dpCount[nums.length-1]=1;
        for(int i=nums.length-2;i>=0;i--){
            int maxSeq = 1;
            int count = 1;
            for(int j = i+1;j<nums.length;j++){
                if(nums[i]>=nums[j])
                    continue;
                if(maxSeq==dp[j]+1){
                    count +=dpCount[j];
                }
                if(maxSeq<dp[j]+1){
                    count = dpCount[j];
                    maxSeq = dp[j]+1;
                }
            }
            dp[i] = maxSeq;
            dpCount[i] = count;
        }
        int max=0;
        int maxCount =0;
        for(int i =0;i<nums.length;i++){
            if(max == dp[i]){
                maxCount+=dpCount[i];
            }
            if(max<dp[i]){
                max = dp[i];
                maxCount = dpCount[i];
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        NumberOfLongestIncreasingSubsequence cl = new NumberOfLongestIncreasingSubsequence();
        System.out.println(cl.findNumberOfLIS(new int[]{1,2,4,3,5,4,7,2}));
    }
}
