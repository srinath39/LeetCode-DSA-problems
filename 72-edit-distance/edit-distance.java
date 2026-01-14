class Solution {
    public static int[][] mat;
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        if(n==0){
            return m;
        }
        if(m==0){
            return n;
        }
        mat=new int[n][m];
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                if(word1.charAt(i)==word2.charAt(j)){
                    mat[i][j]=getValue(i-1,j-1);
                }else{
                    mat[i][j]=Math.min(getValue(i-1,j),Math.min(getValue(i,j-1),getValue(i-1,j-1)))+1;
                }
            }
        }
        return mat[n-1][m-1];
    }

    public int getValue(int i,int j){
        if(i<0){
            return j+1;
        }
        if(j<0){
            return i+1;
        }
        return mat[i][j];
    }
}