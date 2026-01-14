class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        int[][] mat=new int[n+1][m+1];
        for(int i=1;i<=m;++i){
            mat[0][i]=mat[0][i-1]+s2.charAt(i-1);
        }
        for(int i=1;i<=n;++i){
            mat[i][0]=mat[i-1][0]+s1.charAt(i-1);
        }
        for(int i=1;i<=n;++i){
            for(int j=1;j<=m;++j){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    mat[i][j]=mat[i-1][j-1];
                }else{
                    mat[i][j]=Math.min(mat[i-1][j]+s1.charAt(i-1),mat[i][j-1]+s2.charAt(j-1));
                }
            }
        }
        return mat[n][m];
    }

    
    }
