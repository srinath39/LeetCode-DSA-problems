class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return min_cost(n,cost,dp);
    }

    public int min_cost(int n,int[] cost,int[] dp){
        if(n==0 || n==1){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int a=min_cost(n-1,cost,dp)+cost[n-1];
        int b=min_cost(n-2,cost,dp)+cost[n-2];
        dp[n]=(int)Math.min(a,b);
        return dp[n];
    }
}