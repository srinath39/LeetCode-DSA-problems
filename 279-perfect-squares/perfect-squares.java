class Solution {
    public int[][] mat;
    public int[] arr;
    public int numSquares(int n) {
        int k=(int)Math.sqrt(n);
        arr=new int[k];
        for(int i=1;i<=k;++i){
            arr[i-1]=i*i;
        }
        mat=new int[n+1][k];
        for(int[] dp:mat){
            Arrays.fill(dp,-1);
        }
        return minSubsetSize(n,k-1);
    }

    public int minSubsetSize(int sum,int i){
        if(i<0){
            return Integer.MAX_VALUE;
        }
        if(sum==0){
            return 0;
        }
        if(mat[sum][i]!=-1){
            return mat[sum][i];
        }
        int x=Integer.MAX_VALUE;
        int y;
        if((sum-arr[i])>=0){
            x=minSubsetSize(sum-arr[i],i)+1;
        }
        y=minSubsetSize(sum,i-1);
        mat[sum][i]=Math.min(x,y);
        return mat[sum][i];
    }
}