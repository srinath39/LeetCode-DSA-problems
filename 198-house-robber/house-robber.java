class Solution {
    public static int[] arr;
    public static int n;
    public static int[] dp;
    public int rob(int[] nums) {
        arr=nums;
        n=nums.length;
        int ans=0;
        dp=new int[n];
        Arrays.fill(dp,-1);
        for(int i=0;i<n;++i){
            ans=Math.max(ans,maxMoney(i));
        }
        return ans;
    }

    public int maxMoney(int j){
        if(j>=n){
            return 0;
        }
        if(dp[j]!=-1){
            return dp[j];
        }
        
        if(j==n-1 || j==n-2){
            dp[j]=arr[j];
            return arr[j];
        }
        dp[j]=0;
        for(int k=j+2;k<n;++k){
            dp[j]=Math.max(dp[j],maxMoney(k));
        }
        return dp[j]=dp[j]+arr[j];
    }
}