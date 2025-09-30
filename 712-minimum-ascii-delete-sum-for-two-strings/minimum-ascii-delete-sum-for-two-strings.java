class Solution {
    public static String A;
    public static String B;
    public static int[][] mat;
    public static int[] presumA;
    public static int[] presumB;
    public int minimumDeleteSum(String s1, String s2) {
        A=s1;
        B=s2;
        int n=s1.length();
        int m=s2.length();

        presumA=new int[n];
        presumA[0]=s1.charAt(0);
        for(int i=1;i<n;++i){
            presumA[i]=presumA[i-1]+s1.charAt(i);
        }

        presumB=new int[m];
        presumB[0]=s2.charAt(0);
        for(int i=1;i<m;++i){
            presumB[i]=presumB[i-1]+s2.charAt(i);
        }

        mat=new int[n][m];
        for(int[] dp:mat){
            Arrays.fill(dp,-1);
        }
        return minAsciiSumDeletionOperations(n-1,m-1);
    }

    public int minAsciiSumDeletionOperations(int i,int j){
        if(i<0 && j<0){
            return i+1;
        }
        if(i<0){
            return presumB[j];
        }
        if(j<0){
            return presumA[i];
        }
        if(mat[i][j]!=-1){
            return mat[i][j];
        }
        if(A.charAt(i)==B.charAt(j)){
            mat[i][j]=minAsciiSumDeletionOperations(i-1,j-1);
            return mat[i][j];
        }
        int delInA= minAsciiSumDeletionOperations(i-1,j)+A.charAt(i);
        int delInB=minAsciiSumDeletionOperations(i,j-1)+B.charAt(j);
        mat[i][j]=Math.min(delInA,delInB);
        return mat[i][j];
    }
}