class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        int[] res=new int[2];
        if(n==2){
            res[0]=0;
            res[1]=1;
            return res;
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(target-nums[i])){
                res[0]=map.get(target-nums[i]);
                res[1]=i;
            }
            else{
                map.put(nums[i],i);
            }
        }
        return res;
    }
}