class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visited=new boolean[m][n];
        int count=0;
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(grid[i][j]=='1' && !visited[i][j]){
                    ++count;
                    BFS(i,j,grid,visited,m,n);
                }
            }
        }
        return count;
    }

    public void BFS(int i,int j,char[][] grid,boolean[][] visited,int m,int n){
        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{i,j});
        visited[i][j]=true;
        while(!q.isEmpty()){
            int[] cur=q.remove();
            for(int k=0;k<4;k++){
                int x=cur[0]+dr[k];
                int y=cur[1]+dc[k];
                if(x>=0 && x<=m-1 && y>=0 && y<=n-1 && grid[x][y]=='1' && !visited[x][y]){
                    q.add(new int[]{x,y});
                    visited[x][y]=true;
                }
            }
        }
    }
}