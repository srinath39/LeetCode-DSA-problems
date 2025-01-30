class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==1){
            return 1;
        }
        int[] cache=new int[nums.length];
        int k=1;
        int temp=nums[0];
        cache[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            if(temp!=nums[i]){
                k++;
                temp=nums[i];
                cache[k-1]=nums[i];
            }
        }
        for(int j=0;j<k;j++){
            nums[j]=cache[j];
        }
        return k;
    }
}