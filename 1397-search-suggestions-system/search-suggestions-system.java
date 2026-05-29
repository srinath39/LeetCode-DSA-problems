class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        HashMap<String,Integer> map=new HashMap<>();
        List<List<String>> cache=new ArrayList<>();
        List<String> previous=new ArrayList<>();
        for(int i=0;i<products.length;++i){
            map.put(products[i],products[i].length());
            previous.add(products[i]);
        }
        cache.add(previous);
        int len=searchWord.length();
        for(int i=1;i<=len;++i){
            List<String> ref=new ArrayList<>();
            List<String> prev=cache.get(i-1);
            for(int j=0;j<prev.size();++j){
                if(map.get(prev.get(j))>=i && (prev.get(j).charAt(i-1)==searchWord.charAt(i-1))){
                    ref.add(prev.get(j));
                }
            }
            cache.add(ref);
        }

        List<List<String>> ans=new ArrayList<>();
        for(int i=1;i<cache.size();++i){
            List<String> ref=cache.get(i);
                if(ref.size()<=3){
                    ans.add(ref);
                }else{
                    ans.add(ref.subList(0,3));
                }
        }
        return ans;
    }
}