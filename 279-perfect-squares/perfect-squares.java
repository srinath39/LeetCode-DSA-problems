class Solution {
    public int[] dp;
    public int[] arr;
    public int k;
    public int numSquares(int n) {
        k=(int)Math.sqrt(n);
        arr=new int[k];
        for(int i=1;i<=k;++i){
            arr[i-1]=i*i;
        }
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return minSubsetSize(n);
    }

    public int minSubsetSize(int s){
        if(s<0){
            return Integer.MAX_VALUE;
        }
        if(s==0){
            return 0;
        }
        if(dp[s]!=-1){
            return dp[s];
        }
        dp[s]=Integer.MAX_VALUE;
        for(int i=0;i<k;++i){
            int val=minSubsetSize(s-arr[i]);
            dp[s]=Math.min(dp[s],val==Integer.MAX_VALUE?val:val+1);
        }
        return dp[s];
    }
}