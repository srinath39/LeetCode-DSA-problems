class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> list=new ArrayList<>();
        Map<Integer,HashSet<Integer>> map=new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            if(!map.containsKey(nums1[i])){
                map.put(nums1[i],new HashSet<Integer>());
            }
            map.get(nums1[i]).add(1);
        }

        for(int i=0;i<nums2.length;i++){
            if(!map.containsKey(nums2[i])){
                map.put(nums2[i],new HashSet<>());
            }
            map.get(nums2[i]).add(2);
        }

        for(int i=0;i<nums3.length;i++){
            if(!map.containsKey(nums3[i])){
                map.put(nums3[i],new HashSet<>());
            }
            map.get(nums3[i]).add(3);
        }

        for(Map.Entry<Integer,HashSet<Integer>> entry:map.entrySet()){
            if(entry.getValue().size()>=2){
                list.add(entry.getKey());
            }
        }
        return list;
    }
}