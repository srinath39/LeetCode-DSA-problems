class Solution {
    public static String A;
    public static String B;
    public static int[][] mat;
    public int minDistance(String word1, String word2) {
        A=word1;
        B=word2;
        int n=word1.length();
        int m=word2.length();
        mat=new int[n][m];
        for(int[] dp:mat){
            Arrays.fill(dp,-1);
        }
        return minDeletionOperations(n-1,m-1);
    }

    public int minDeletionOperations(int i,int j){
        if(i<0){
            return j+1;
        }
        if(j<0){
            return i+1;
        }
        if(mat[i][j]!=-1){
            return mat[i][j];
        }
        if(A.charAt(i)==B.charAt(j)){
            mat[i][j]=minDeletionOperations(i-1,j-1);
            return mat[i][j];
        }
        int delInA= minDeletionOperations(i-1,j)+1;
        int delInB=minDeletionOperations(i,j-1)+1;
        mat[i][j]=Math.min(delInA,delInB);
        return mat[i][j];
    }
}