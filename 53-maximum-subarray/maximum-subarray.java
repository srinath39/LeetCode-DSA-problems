class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int sum=nums[0];
        int ans=sum;
        for(int i=1;i<n;i++){
            sum=Math.max(nums[i],nums[i]+sum);
            ans=Math.max(ans,sum);
        }
        return ans;
    }
}