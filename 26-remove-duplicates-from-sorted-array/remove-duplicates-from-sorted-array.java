class Solution {
    public int removeDuplicates(int[] nums) {
        int k=1;
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                i=i+1;
                nums[i]=nums[j];
                k++;
            }
        }
        return k;
    }
}