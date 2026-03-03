class Solution {
    public static int[] dp;
    public char findKthBit(int n, int k) {
        dp=new int[n+1];
        dp[1]=1;
        for(int i=2;i<=n;++i){
            dp[i]=(2*dp[i-1])+1;
        }
        return (char)(kthBitinBinaryString(n,k)+'0');
    }

    public int kthBitinBinaryString(int n,int k){
        if(k==1){
            return 0;
        }
        int c=(dp[n]/2)+1;
        if(k==c){
            return 1;
        }else if(k<c){
            return kthBitinBinaryString(n-1,k);
        }
        return 1^kthBitinBinaryString(n-1,c-Math.abs(c-k));
    }
}