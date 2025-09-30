class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int[][] mat=new int[m+1][n+1];
        for(int i=1;i<=m;++i){
            mat[i][0]=i;
        }
        for(int j=1;j<=n;++j){
            mat[0][j]=j;
        }

        for(int i=1;i<=m;++i){
            for(int j=1;j<=n;++j){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    mat[i][j]=mat[i-1][j-1];
                }else{
                    mat[i][j]=Math.min(mat[i-1][j],Math.min(mat[i-1][j-1],mat[i][j-1]))+1;
                }
            }
        }
        return mat[m][n];
    }
}