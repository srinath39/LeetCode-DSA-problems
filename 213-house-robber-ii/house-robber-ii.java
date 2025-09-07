class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        return Math.max(maximumAmountIncludeLastElement(n,nums),maximumAmountExcludeLastElement(n,nums));
    }

    public int maximumAmountIncludeLastElement(int n,int[] nums){
        int[] dp=new int[n];
        dp[1]=nums[1];
        for(int i=2;i<n;++i){
            dp[i]=Math.max(dp[i],Math.max(((i-2)<=0?0:dp[i-2])+nums[i],dp[i-1]));
        }
        return dp[n-1];
    }

    public int maximumAmountExcludeLastElement(int n,int[] nums){
        int[] dp=new int[n];
        dp[0]=nums[0];
        for(int i=1;i<n-1;++i){
            dp[i]=Math.max(dp[i],Math.max(((i-2)<0?0:dp[i-2])+nums[i],dp[i-1]));
        }
        return dp[n-2];
    }
}