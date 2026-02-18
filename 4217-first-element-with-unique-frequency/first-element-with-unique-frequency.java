class Solution {
    public int firstUniqueFreq(int[] nums) {
        LinkedHashMap<Integer,Integer> map=new LinkedHashMap<>();
        int n=nums.length;
        for(int i=0;i<n;++i){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        LinkedHashMap<Integer,List<Integer>> rev=new LinkedHashMap<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            rev.computeIfAbsent(entry.getValue(),key->new LinkedList<>()).add(entry.getKey());
        }
        for(Map.Entry<Integer,List<Integer>> entry:rev.entrySet()){
            if(entry.getValue().size()==1){
                return entry.getValue().get(0);
            }
        }
        return -1;
    }
}