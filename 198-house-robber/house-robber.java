class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        dp[0]=nums[0];
        for(int i=1;i<n;++i){
            dp[i]=Math.max(((i-2)<0?0:dp[i-2])+nums[i],dp[i-1]);
        }
        return dp[n-1];
    }
}