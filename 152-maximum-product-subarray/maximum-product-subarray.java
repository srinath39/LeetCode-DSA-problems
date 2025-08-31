class Solution {
    public int maxProduct(int[] nums) {
      int n=nums.length;
      // forward 
      int prod=1;
      int ans=Integer.MIN_VALUE;
      for(int i=0;i<n;++i){
        prod*=nums[i];
        ans=Math.max(ans,prod);
        if(nums[i]==0){
            prod=1;
        }
      }

      prod=1;
      for(int i=n-1;i>=0;--i){
        prod*=nums[i];
        ans=Math.max(ans,prod);
        if(nums[i]==0){
            prod=1;
        }
      }

      return ans;
    }
}