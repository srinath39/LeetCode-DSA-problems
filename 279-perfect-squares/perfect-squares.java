class Solution {
    // public int[] dp;
    // public int[] arr;
    // public int k;
    public int numSquares(int n) {
        int k=(int)Math.sqrt(n);
        int[] dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int s=1;s<=n;++s){
            for(int i=1;i<=k;++i){
                if((s-(i*i))>=0){
                    dp[s]=Math.min(dp[s],dp[s-(i*i)]+1);
                }
            }
        }
        return dp[n];
    }

    // public int minSubsetSize(int s){
    //     if(s<0){
    //         return Integer.MAX_VALUE;
    //     }
    //     if(s==0){
    //         return 0;
    //     }
    //     if(dp[s]!=-1){
    //         return dp[s];
    //     }
    //     dp[s]=Integer.MAX_VALUE;
    //     for(int i=0;i<k;++i){
    //         int val=minSubsetSize(s-arr[i]);
    //         dp[s]=Math.min(dp[s],val==Integer.MAX_VALUE?val:val+1);
    //     }
    //     return dp[s];
    // }
}