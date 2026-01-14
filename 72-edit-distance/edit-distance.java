class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int[][] mat=new int[n+1][m+1];
        for(int i=0;i<=m;++i){
            mat[0][i]=i;
        }
        for(int j=0;j<=n;++j){
            mat[j][0]=j;
        }
        for(int i=1;i<=n;++i){
            for(int j=1;j<=m;++j){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    mat[i][j]=mat[i-1][j-1];
                }else{
                    mat[i][j]=Math.min(mat[i-1][j],Math.min(mat[i][j-1],mat[i-1][j-1]))+1;
                }
            }
        }
        return mat[n][m];
    }

}