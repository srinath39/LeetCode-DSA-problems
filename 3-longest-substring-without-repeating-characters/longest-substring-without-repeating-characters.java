class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] arr=s.toCharArray();
        int n=arr.length;
        int i=0;
        int[] dat=new int[128+1];
        Arrays.fill(dat,-1);
        int ans=0;
        for(int j=0;j<n;++j){
            int asc=arr[j];
            if(dat[asc]==-1 || dat[asc]<i){
                dat[asc]=j;
            }else{
                i=dat[asc]+1;
                dat[asc]=j;
            }
            ans=Math.max(ans,j-i+1);
        }
        return ans;
    }
}