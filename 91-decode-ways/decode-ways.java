class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        int[] dp=new int[n+1];
        dp[0]=1;
        int x,y;
        for(int i=1;i<=n;++i){
            x=0;
            y=0;
            if(s.charAt(i-1)!='0'){
                x=dp[i-1];
            }
            if(i-1>0 && (Integer.parseInt(s.substring(i-2,i))>=10) && (Integer.parseInt(s.substring(i-2,i))<=26)){
                y=dp[i-2];
            }
            dp[i]=x+y;
        }
        return dp[n];
    }
}