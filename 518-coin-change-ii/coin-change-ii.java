class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] mat=new int[amount+1][n];
        for(int j=0;j<n;++j){
            mat[0][j]=1;
        }
        int count;
        for(int i=1;i<=amount;++i){
            for(int j=0;j<n;++j){
                count=0;
                if((i-coins[j])>=0){
                   count=mat[i-coins[j]][j]; 
                }
                if((j-1)>=0){
                    count+=mat[i][j-1];
                }
                mat[i][j]=count;
            }
        }
        return mat[amount][n-1];
    }
}