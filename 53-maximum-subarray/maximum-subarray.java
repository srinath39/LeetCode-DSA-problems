class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int sum=0;
        int[] dp=new int[n];
        dp[0]=nums[0];
        int ans=nums[0];
        for(int i=1;i<n;++i){
           dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
           ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}