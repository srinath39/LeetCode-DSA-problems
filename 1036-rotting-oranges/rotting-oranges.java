class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
            }
        }
        int t=BFS(grid,q);
        if(isFreshOrangeLeft(grid)){
            return -1;
        }
        if(t==-1){
            return 0;
        }
        return t;
    }

    public int BFS(int[][] grid,Queue<int[]> q){
        int n=grid.length;
        int m=grid[0].length;
        int t=-1;
        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};
        while(!q.isEmpty()){
            t++;
            int sz=q.size();
            for(int i=0;i<sz;i++){
                int[] cur=q.remove();
                for(int j=0;j<4;j++){
                    int x=cur[0]+dr[j];
                    int y=cur[1]+dc[j];
                    if(x>=0 && x<=n-1 && y>=0 && y<=m-1 && grid[x][y]==1){
                        q.add(new int[]{x,y});
                        grid[x][y]=2;
                    }
                }
            }
        }
        return t;
    }

    public boolean isFreshOrangeLeft(int[][] grid){
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    return true;
                }
            }
        }
        return false;
    }
}