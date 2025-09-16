class Solution {
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int total_count=0;
        Queue<int[]> q=new LinkedList<>();
        boolean[][] visited=new boolean[m][n];
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(grid[i][j]==1){
                    ++total_count;
                    if(i==0||(i==m-1)||j==0||(j==n-1)){
                        q.add(new int[]{i,j});
                        visited[i][j]=true;
                    }
                }
            }
        }
        //  Multi-Source BFS
        int boundary_ones=0;
        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};
        while(!q.isEmpty()){
            int[] cur=q.remove();
            ++boundary_ones;
            for(int i=0;i<4;++i){
                int x=cur[0]+dr[i];
                int y=cur[1]+dc[i];
                if(x>=0 && x<=m-1 && y>=0 && y<=n-1 && grid[x][y]==1 && !visited[x][y] ){
                    visited[x][y]=true;
                    q.add(new int[]{x,y});
                }
            }
        }
        return total_count-boundary_ones;
    }
}