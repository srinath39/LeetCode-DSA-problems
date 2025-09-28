class Solution {
    public static Queue<int[]> multiSrcBfsQueue;
    public static boolean[][] multiSrcVisited;
    public int shortestBridge(int[][] grid) {
        int[] cordOne=getACordinateWithOne(grid);
        multiSrcBfsQueue=new LinkedList<>();
        loadSingleIslandCordinates(cordOne[0],cordOne[1],grid);
        return getShortestDistance(grid);
    }

    public int[] getACordinateWithOne(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(grid[i][j]==1){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{0,0};
    }

    public void loadSingleIslandCordinates(int i,int j,int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{i,j});
        multiSrcVisited=new boolean[m][n];
        multiSrcVisited[i][j]=true;
        while(!q.isEmpty()){
            int[] cur=q.remove();
            multiSrcBfsQueue.add(cur);
            for(int k=0;k<4;++k){
                int x=cur[0]+dr[k];
                int y=cur[1]+dc[k];
                if(x>=0 && x<=m-1 && y>=0 && y<=n-1 && grid[x][y]==1 && !multiSrcVisited[x][y]){
                    q.add(new int[]{x,y});
                    multiSrcVisited[x][y]=true;
                }
            }
        }
    }

    public int getShortestDistance(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};
        int steps=0;
        while(!multiSrcBfsQueue.isEmpty()){
            int size=multiSrcBfsQueue.size();
            for(int i=0;i<size;++i){
                int[] cur=multiSrcBfsQueue.remove();
                for(int j=0;j<4;++j){
                    int x=cur[0]+dr[j];
                    int y=cur[1]+dc[j];
                    if(x>=0 && x<=m-1 && y>=0 && y<=n-1 && !multiSrcVisited[x][y]){
                        multiSrcBfsQueue.add(new int[]{x,y});
                        multiSrcVisited[x][y]=true;
                        if(grid[x][y]==1){
                            return steps;
                        }
                    }
                }
            }
            ++steps;
        }
        return steps;
    }
}