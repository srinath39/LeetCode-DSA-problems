class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] mat=new int[amount+1][n];
        for(int j=0;j<n;++j){
            mat[0][j]=1;
        }
        int x,y;
        for(int i=1;i<=amount;++i){
            for(int j=0;j<n;++j){
                x=0;
                y=0;
                if((i-coins[j])>=0){
                   x=mat[i-coins[j]][j]; 
                }
                if((j-1)>=0){
                    y=mat[i][j-1];
                }
                mat[i][j]=(x+y);
            }
        }
        return mat[amount][n-1];
    }
}