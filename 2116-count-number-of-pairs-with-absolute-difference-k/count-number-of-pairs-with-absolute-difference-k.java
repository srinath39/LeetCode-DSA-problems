class Solution {
    public int countKDifference(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num: nums){
            if (count.containsKey(num)){
                count.put(num, count.get(num)+1);
            }
            else{
                count.put(num, 1);
            }
        }
        int res = 0;
        for (int num: nums){
            if (count.containsKey(num+k)){
                res += count.get(num+k);
            }
        }
        return res;
    }
}