class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int ans=1;
        int[] parent=new int[n];
        for(int i=1;i<n;++i){
            int max=0;
            for(int j=0;j<i;++j){
                if(nums[j]<nums[i] && dp[j]>max){
                    max=dp[j];
                    dp[i]=max+1;
                    parent[i]=max;
                }
            }
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}