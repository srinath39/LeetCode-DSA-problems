class Solution {
    public int climbStairs(int n) {
       int[] dp=new int[n+1];
       Arrays.fill(dp,-1);
       return no_of_ways(n,dp);
    }

    public int no_of_ways(int n,int[] dp){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n]=no_of_ways(n-1,dp)+no_of_ways(n-2,dp);
        return dp[n];
    }
}