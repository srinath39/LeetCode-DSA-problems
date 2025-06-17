class Solution {
    public int specialTriplets(int[] nums) {
        int n=nums.length;
        int m=(int)(1e9+7);
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] left=new int[n];
        int[] right=new int[n];
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i]*2)){
                left[i]=map.get(nums[i]*2);
            }
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        map.clear();
        for(int i=n-1;i>=0;i--){
            if(map.containsKey(nums[i]*2)){
                right[i]=map.get(nums[i]*2);
            }
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        long count=0L;
        for(int i=0;i<n;i++){
            count=(count+(1L*left[i]*right[i]));
        }
        return (int)(count%m);
    }
}