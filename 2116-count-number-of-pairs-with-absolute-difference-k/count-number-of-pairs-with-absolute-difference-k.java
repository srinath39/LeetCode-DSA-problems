class Solution {
    public int countKDifference(int[] nums, int k) {
        int n=nums.length;
        if(n==1){
            return 0;
        }
        if(n==2){
            return Math.abs(nums[0]-nums[1])==k?1:0;
        }
        int count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int ele=nums[i];
            count =count+map.getOrDefault(ele+k,0)+map.getOrDefault(ele-k,0);            
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        return count;
    }
}