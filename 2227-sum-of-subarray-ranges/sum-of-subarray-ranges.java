class Solution {
    public long subArrayRanges(int[] nums) {
        long sum=0L;
        int n=nums.length;
        int max,min;
        for(int i=0;i<n;++i){
            min=nums[i];
            max=nums[i];
            for(int j=i+1;j<n;++j){
                min=Math.min(min,nums[j]);
                max=Math.max(max,nums[j]);
                sum+=(max-min);
            }            
        }
        return sum;
    }
}