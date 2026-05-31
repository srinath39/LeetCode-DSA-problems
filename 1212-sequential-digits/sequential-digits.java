class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans=new ArrayList<>();
        for(int i=1;i<9;++i){
            int val=i;
            int s=val;
            do{
                if(val==9){
                    break;
                }
                s=(s*10)+(val+1);
                val+=1;
                if(s>=low && s<=high){
                    ans.add(s);
                }
            }while(s<=high);
        }
        Collections.sort(ans);
        return ans;
    }
}