class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] arr=s.toCharArray();
        int n=arr.length;
        int i=0;
        HashMap<Character,Integer> map=new HashMap<>();
        int ans=0;
        for(int j=0;j<n;++j){
            if(!map.containsKey(arr[j])){
                map.put(arr[j],j);
            }else{
                for(int k=i;k<map.get(arr[j]);++k){
                    map.remove(arr[k]);
                }
                i=map.get(arr[j])+1;
                map.put(arr[j],j);
            }
            ans=Math.max(ans,j-i+1);
        }
        return ans;
    }
}