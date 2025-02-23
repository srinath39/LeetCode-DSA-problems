class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        int[] res=new int[2];
        if(n==2){
            res[0]=0;
            res[1]=1;
            return res;
        }
        for(int i=0;i<n-1;i++){
                for(int j=i+1;j<n;j++){
                    if((target-nums[i])==nums[j]){
                        res[0]=i;
                        res[1]=j;
                        return res;
                    }
                }
            }
        return res;
    }
}