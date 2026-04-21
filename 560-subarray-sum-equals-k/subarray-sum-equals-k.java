class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        int[] pre=new int[n];
        HashMap<Integer,Integer> map=new HashMap<>();
        pre[0]=nums[0];
        for(int i=1;i<n;++i){
            pre[i]=pre[i-1]+nums[i];
        }
        int count=0;
        map.put(0,1);
        for(int i=0;i<n;++i){
            if(map.containsKey(pre[i]-k)){
                count+=map.get(pre[i]-k);
            }
            map.put(pre[i],map.getOrDefault(pre[i],0)+1);
        }
        return count;
    }
}