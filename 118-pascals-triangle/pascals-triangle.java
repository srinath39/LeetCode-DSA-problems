class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> temp;
        for(int i=1;i<=numRows;i++){
            temp = new ArrayList<>();
            temp.add(0,1); 
            if(i==1){
                result.add(temp);
                continue;
            }
            if(result.get(i-2)!=null){
                int m=0;
                int n=1;
                while(n<result.get(i-2).size()){
                    temp.add(m+1,result.get(i-2).get(m)+result.get(i-2).get(n));
                    m++;
                    n++;
                }
                temp.add(n,1);
            }
            result.add(temp);
        }
        return result;
    }
}