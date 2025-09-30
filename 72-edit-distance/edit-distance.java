class Solution {
    public static String src;
    public static String dest;
    public int[][] mat;
    public int minDistance(String word1, String word2) {
        src=word1;
        dest=word2;
        int n=src.length();
        int m=dest.length();
        mat=new int[n][m];
        for(int[] dp:mat){
            Arrays.fill(dp,-1);
        }
        return minimumOperation(n-1,m-1);
    }

    public int minimumOperation(int i,int j){
        if(i<0){
            return j+1;
        }
        if(j<0){
            return i+1;
        }
        if(mat[i][j]!=-1){
            return mat[i][j];
        }
        if(src.charAt(i)==dest.charAt(j)){
            mat[i][j]=minimumOperation(i-1,j-1);
            return mat[i][j];
        }
        int del=minimumOperation(i-1,j)+1;
        int sub=minimumOperation(i-1,j-1)+1;
        int ins=minimumOperation(i,j-1)+1;
        mat[i][j]=Math.min(del,Math.min(sub,ins));
        return mat[i][j];
    }
}