class Solution {
    public boolean areOccurrencesEqual(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))!=null){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }
            else{
                map.put(s.charAt(i),0);
            }
        }
        Set<Integer> set=new HashSet<>(map.values());
        if(set.size()==1){
            return true;
        }
        return false;
    }
}