class Solution {
    public static int[][][] mat;
    public static int k;
    public static int[] arr;
    public static int n;
    public int findTargetSumWays(int[] nums, int target) {
        n=nums.length;
        k=target;
        arr=nums;
        mat=new int[n][1001][2];
        for(int i=0;i<n;++i){
            for(int j=0;j<1001;++j){
                mat[i][j][0]=-1;
                mat[i][j][1]=-1;
           }
        }
        totalPossibleExpressions(0,0);
        return mat[0][0][0];
    }

    public int totalPossibleExpressions(int index,int curSum){
        if(index==n){
            if(curSum==k){
                return 1;
            }
            return 0;
        }
        int modSum=Math.abs(curSum);
        int sign=curSum<0?1:0;

        if(mat[index][modSum][sign]!=-1){
            return mat[index][modSum][sign];
        }
        mat[index][modSum][sign]=totalPossibleExpressions(index+1,curSum+arr[index]) + totalPossibleExpressions(index+1,curSum-arr[index]);
        return mat[index][modSum][sign];
    }
}