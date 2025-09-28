class Solution {
    public int closedIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        boolean[][] visited=new boolean[m][n];
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(grid[i][j]==0 && !visited[i][j] && !isBorderCordinate(i,j,m,n) && BFS(i,j,m,n,grid,visited)){
                    ++count;
                }
            }
        }
        return count;
    }

    public boolean BFS(int i,int j,int m,int n,int[][] grid,boolean[][] visited){
        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{i,j});
        visited[i][j]=true;
        boolean isBorderCordinatePresent=false;
        while(!q.isEmpty()){
            int[] cur=q.remove();
            for(int k=0;k<4;++k){
                int x=cur[0]+dr[k];
                int y=cur[1]+dc[k];
                if(x>=0 && x<=m-1 && y>=0 && y<=n-1 && grid[x][y]==0 && !visited[x][y]){
                    if(isBorderCordinate(x,y,m,n)){
                        isBorderCordinatePresent=true;
                    }
                    q.add(new int[]{x,y});
                    visited[x][y]=true;
                }
            }
        }
        return !isBorderCordinatePresent;
    }

    public boolean isBorderCordinate(int i,int j,int m,int n){
        if(i==0 || i==m-1 || j==0 || j==n-1){
            return true;
        }
        return false;
    }
}