class Solution {
    public static int m;
    public static int[] dp;
    public int numSquares(int n) {
        m=0;
        for(int i=1;i<=n;i++){
            if(n-(i*i)>=0){
                ++m;
            }else{
                break;
            }
        }
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        minSubSetSize(n);
        return dp[n];
    }

    public int minSubSetSize(int n){
        if(n<0){
            return Integer.MAX_VALUE;
        }
        if(n==0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int val;
        dp[n]=Integer.MAX_VALUE;
        for(int i=1;i<=m;++i){
            if((n-(i*i))>=0){ 
                val=minSubSetSize(n-(i*i));
                if(val!=Integer.MAX_VALUE){
                    dp[n]=Math.min(dp[n],val+1);
                }
            }
        }
        return dp[n];
    }
}