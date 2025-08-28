class Solution {
    public static int[] arr;
    public static int[][] mat;
    public int maxCoins(int[] nums) {
        int n=nums.length;
        arr=new int[n+2];
        arr[0]=1;
        arr[n+1]=1;
        for(int i=1;i<=n;++i){
            arr[i]=nums[i-1];
        }
        mat=new int[n+2][n+2];
        for(int[] dp:mat){
            Arrays.fill(dp,-1);
        }
        maxRewardCoins(0,n+1);
        return mat[0][n+1];
    }

    public int maxRewardCoins(int i,int j){
        if(i+1==j){
            return 0;
        }
        if(mat[i][j]!=-1){
            return mat[i][j];
        }
        mat[i][j]=Integer.MIN_VALUE;
        for(int k=i+1;k<j;++k){
            mat[i][j]=Math.max(mat[i][j],maxRewardCoins(i,k)+maxRewardCoins(k,j)+arr[i]*arr[j]*arr[k]);
        }
        return mat[i][j];
    }
}