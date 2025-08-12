class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int prefix_sum=0,remainder;
        int count=0;
        map.put(0,1);
        for(int i=0;i<n;i++){
            prefix_sum+=nums[i];
            remainder=((prefix_sum)%k+k)%k;
            if(map.containsKey(remainder)){
                count+=map.get(remainder);
                map.put(remainder,map.get(remainder)+1);
            }else{
                map.put(remainder,1);
            }
        }
        return count;
    }
}