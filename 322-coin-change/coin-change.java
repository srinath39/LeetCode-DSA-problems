class Solution {
    public static int[][] mat;
    public static int[] arr;
    public int coinChange(int[] coins, int amount) {
        arr=coins;
        int n=coins.length;
        mat=new int[n][amount+1];
        for(int[] dp:mat){
            Arrays.fill(dp,-1);
        }
        minCoins(n-1,amount);
        if(mat[n-1][amount]==Integer.MAX_VALUE){
            return -1;
        }
        return mat[n-1][amount];
    }

    public int minCoins(int index,int sum){
        if(sum<0 || index<0){
            return Integer.MAX_VALUE;
        }

        if(sum==0){
            mat[index][sum]=0;
            return 0;
        }

        if(mat[index][sum]!=-1){
            return mat[index][sum];
        }
        int mintake=minCoins(index,sum-arr[index]);
        mat[index][sum]= Math.min(mintake==Integer.MAX_VALUE?mintake:mintake+1,minCoins(index-1,sum));
        return mat[index][sum];
    }

    
}