class Solution {
    public int findDuplicate(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int l=0;
        int r=n-1;
        while(l+1<r){
            int mid=(l+r)/2;
            if(nums[mid]<=mid){
                r=mid;
            }else{
                l=mid;
            }
        }
        return nums[l];
    }

}