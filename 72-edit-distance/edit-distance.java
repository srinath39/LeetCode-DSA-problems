class Solution {
    public static String A;
    public static String B;
    public static int[][] mat;
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        A=word1;
        B=word2;
        mat=new int[n][m];
        for(int[] dp:mat){
            Arrays.fill(dp,-1);
        }
        return minOperations(n-1,m-1);
    }

    public int minOperations(int i,int j){
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
            mat[i][j]=minOperations(i-1,j-1);
        }else{
            mat[i][j]=Math.min(minOperations(i-1,j),Math.min(minOperations(i,j-1),minOperations(i-1,j-1)))+1;
        }
        return mat[i][j];
    }
}