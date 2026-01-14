class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int[][] mat=new int[n+1][m+1];
        for(int i=1;i<=n;++i){
            for(int j=1;j<=m;++j){
                if(nums1[i-1]==nums2[j-1]){
                    mat[i][j]=mat[i-1][j-1]+1;
                }else{
                    mat[i][j]=Math.max(mat[i-1][j],mat[i][j-1]);
                }
            }
        }
        return mat[n][m];
    }
}