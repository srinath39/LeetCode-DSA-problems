class Solution {
    public int removeElement(int[] nums, int val) {
        int k=0;
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(val!=nums[j]){
                nums[i]=nums[j];
                i++;
                k++;
            }
        }
        return k;
    }
}