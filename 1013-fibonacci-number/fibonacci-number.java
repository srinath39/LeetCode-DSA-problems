class Solution {
    public int fib(int n) {
        if(n==0 || n==1){
            return n;
        }
        int[] dp=new int[n+1];
        // Arrays.fill(dp,-1);
        // return fibDp(n,dp);
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;++i){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    // public int fibDp(int n,int[] dp) {
    //     if(n==0 || n==1){
    //         return n;
    //     }
    //     if(dp[n]!=-1){
    //         return dp[n];
    //     }
    //     dp[n]=fibDp(n-1,dp)+fibDp(n-2,dp);
    //     return dp[n];
    // }
}