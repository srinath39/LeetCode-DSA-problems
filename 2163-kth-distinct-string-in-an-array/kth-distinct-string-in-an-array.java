class Solution {
    public String kthDistinct(String[] arr, int k) {
        if(arr.length==1){
            return k==1?arr[0]:"";
        }
        Map<String,Integer> map=new LinkedHashMap<>();
        List<String> list=new LinkedList();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            if(entry.getValue()==1){
                list.add(entry.getKey());
            }
        }
        if(list.size()<k){
            return "";
        }
        return list.get(k-1);
    }
}