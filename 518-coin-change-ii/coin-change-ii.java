class Solution {
    public int change(int amount, int[] coins) {
        int k=amount;
        int n=coins.length;
        int[] arr =coins;
        int[][] mat=new int[k+1][n];
        for(int j=0;j<n;++j){
            mat[0][j]=1;
        }
        int x,y;
        for(int i=1;i<=k;++i){
            for(int j=0;j<n;++j){
                x=0;
                y=0;
                if((i-arr[j])>=0){
                   x=mat[i-arr[j]][j]; 
                }
                if((j-1)>=0){
                    y=mat[i][j-1];
                }
                mat[i][j]=(x+y);
            }
        }
        return mat[k][n-1];
    }
}