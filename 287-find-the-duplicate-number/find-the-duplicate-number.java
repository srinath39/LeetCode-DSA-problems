class Solution {
    public int findDuplicate(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int l=0;
        int r=n-1;
        while(l+1<r){
            int mid=(l+r)/2;
            if(predicate(mid,nums)==0){
                l=mid;
            }else{
                r=mid;
            }
        }
        return nums[l];
    }

    public int predicate(int mid,int[] arr){
        if(arr[mid]<=mid){
            return 1;
        }
        return 0;
    }
}