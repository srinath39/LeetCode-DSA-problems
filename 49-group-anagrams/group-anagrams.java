class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n=strs.length;
        String[] newS=new String[n];
        for(int i=0;i<n;++i){
            char[] ch=strs[i].toCharArray();
            Arrays.sort(ch);
            newS[i]=String.valueOf(ch);
        }
        HashMap<String,List<String>> map=new HashMap<>();
        for(int i=0;i<n;++i){
            if(map.containsKey(newS[i])){
                map.get(newS[i]).add(strs[i]);
            }else{
                map.computeIfAbsent(newS[i],key->new ArrayList<>()).add(strs[i]);
            }
        }
        List<List<String>> ans=new ArrayList<>();
        for(Map.Entry<String,List<String>> entry:map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }

}