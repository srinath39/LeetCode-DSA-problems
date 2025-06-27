class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        ArrayList<int[]> list=new ArrayList<>();
        int[][] udist=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    list.add(new int[]{i,j});
                }
                udist[i][j]=Integer.MAX_VALUE;
            }
        }

        boolean[][] ubool=new boolean[n][m];
        for(int i=0;i<list.size();i++){
            int[] rotten=list.get(i);
            BFS(rotten,grid,udist,ubool);
        }
        if(isFreshOrangeLeft(ubool,grid)){
            return -1;
        }
        return minMinutes(udist,grid);
    }

    public boolean isFreshOrangeLeft(boolean[][] bool,int[][] grid){
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 && !bool[i][j]){
                    return true;
                }
            }
        }
        return false;
    }

    public int minMinutes(int[][] dist,int[][] grid){
        int max=0;
        for(int i=0;i<dist.length;i++){
            for(int j=0;j<dist[0].length;j++){
                if(grid[i][j]==1){
                    max=Math.max(max,dist[i][j]);
                }
            }
        }
        return max;
    }

    public void BFS(int[] rotten,int[][] grid,int[][] udist,boolean[][] ubool){
        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        q.add(rotten);
        int[][] dist=new int[n][m];
        boolean[][] bool=new boolean[n][m];
        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};
        while(!q.isEmpty()){
            int[] cur=q.remove();
            for(int i=0;i<4;i++){
                int x=cur[0]+dr[i];
                int y=cur[1]+dc[i];
                if(x>=0 && x<=n-1 && y>=0 && y<=m-1 && (!bool[x][y]) && grid[x][y]==1){
                    q.add(new int[]{x,y});
                    dist[x][y]=dist[cur[0]][cur[1]]+1;
                    bool[x][y]=true;
                    ubool[x][y]=true;
                    udist[x][y]=Math.min(udist[x][y],dist[x][y]);
                }
            }
        }
    }
}