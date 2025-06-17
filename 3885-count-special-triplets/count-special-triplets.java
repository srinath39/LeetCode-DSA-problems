class Solution {
    public int specialTriplets(int[] nums) {
        int n=nums.length;
       // int m=(int)(1e9+7);
        int mod = 1_000_000_007;
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
        int count=0;
        for(int i=0;i<n;i++){
            //count=(count%m+(((left[i]%m)*(right[i]%m))%m))%m;
            count = (int)((count + 1L * left[i] * right[i]) % mod);
        }
        return count;
    }
}