class Solution {
    public long countPairs(String[] words) {
        int n=words.length;
        HashMap<String,Integer> map=new HashMap<>();
        long count=0L;
        for(int i=0;i<n;++i){
            char[] arr=words[i].toCharArray();
            char f=arr[0];
            for(int j=0;j<arr.length;++j){
                arr[j]=(char)((arr[j]-f+26)%26);
            }
            String nStr=new String(arr);
            int k=map.getOrDefault(nStr,0);
            count+=k;
            map.put(nStr,k+1);
        }
        return count;
    }
}