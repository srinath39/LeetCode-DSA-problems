class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        int maxArea=0;
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                if(!visited[i][j] && grid[i][j]==1){
                    maxArea=Math.max(maxArea,getAreaOfIsland(new int[]{i,j},visited,grid,n,m));
                }
            }
        }
        return maxArea;
    }

    public int getAreaOfIsland(int[] src,boolean[][] visited,int[][] grid,int n,int m){
        Queue<int[]> q=new LinkedList<>();
        q.add(src);
        visited[src[0]][src[1]]=true;
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        int area=0;
        while(!q.isEmpty()){
            int[] cur=q.remove();
            ++area;
            for(int i=0;i<4;++i){
                int x=dx[i]+cur[0];
                int y=dy[i]+cur[1];
                if(x>=0 && x<=n-1 && y>=0 && y<=m-1 && !visited[x][y] && grid[x][y]==1){
                    visited[x][y]=true;
                    q.add(new int[]{x,y});
                }
            }
        }
        return area;
    }
}