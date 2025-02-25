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
            if(map.containsKey(ele+k)){
                count =count+map.get(ele+k);
            }
            if(map.containsKey(ele-k)){
                count=count+map.get(ele-k);
            }
            if(!map.containsKey(ele)){
                map.put(ele,1);
            }else{
                map.put(ele,map.get(ele)+1);
            }
        }
        return count;
    }
}