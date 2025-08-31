class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n=nums.length;
        int cur_diff=2001;
        int count=0;
        int no_of_subArrays=0;
        int k;
        for(int i=0;i<n-1;++i){
            if((nums[i]-nums[i+1])!=cur_diff){
                if(count>=2){
                    k=count-1;
                    no_of_subArrays+=(k*(k+1))/2;
                }
                count=1;
                cur_diff=nums[i]-nums[i+1];
            }
            else{
                ++count;
            }
        }
        if(count>=2){
            k=count-1;
            no_of_subArrays+=(k*(k+1))/2;
        }
        return no_of_subArrays;
    }
}