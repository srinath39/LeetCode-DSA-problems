class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int rowIndex=rowToSearch(matrix,target);
        if(rowIndex==m){
            return false;
        }
        int eleIndex=isElementPresent(matrix,target,rowIndex);
        if(eleIndex==n || matrix[rowIndex][eleIndex]!=target){
            return false;
        }
        return true;
    }

    public int rowToSearch(int[][] matrix, int target){
        int l=-1;
        int r= matrix.length;
        int n=matrix[0].length;
        while((l+1)<r){
            int mid=(l+r)/2;
            if(target>matrix[mid][n-1]){
                l=mid;
            }else{
                r=mid;
            }
        }
        return r;
    }

    public int isElementPresent(int[][] matrix, int target,int m){
        int l=-1;
        int r=matrix[0].length;
        while((l+1)<r){
            int mid=(l+r)/2;
            if(target>matrix[m][mid]){
                l=mid;
            }else{
                r=mid;
            }
        }
        return r; 
    }
}