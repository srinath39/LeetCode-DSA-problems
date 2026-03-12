class Solution {
    public static List<List<Integer>> ans;
    public List<List<Integer>> combine(int n, int k) {
        ans=new LinkedList<>();
        load(n,k,new LinkedList<>());
        return ans;
    }

    public void load(int i,int k,LinkedList<Integer> t){
        if(k==0){
            ans.add(new LinkedList<>(t));
            return;
        }
        if(i==0){
            return;
        }
        t.addFirst(i);
        load(i-1,k-1,t);
        t.removeFirst();
        load(i-1,k,t);
    }
}