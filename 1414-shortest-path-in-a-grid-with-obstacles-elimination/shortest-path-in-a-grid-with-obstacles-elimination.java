class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        return BFS(grid,m,n,new int[]{0,0},new int[]{m-1,n-1},k);
    }

    public int BFS(int[][] grid,int m,int n,int[] src,int[] dest,int k){
        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};
        Queue<int[]> q=new LinkedList<>();
        boolean[][][] visited=new boolean[m][n][k+1];
        visited[src[0]][src[1]][k]=true;
        q.add(new int[]{src[0],src[1],k,0});
        while(!q.isEmpty()){
            int[] cur=q.remove();
            int power=cur[2];
            int dist=cur[3];
            if(cur[0]==dest[0]&&cur[1]==dest[1]){
                return dist;
            }
            for(int i=0;i<4;i++){
                int x=cur[0]+dr[i];
                int y=cur[1]+dc[i];
                if(x>=0 && x<=m-1 && y>=0 && y<=n-1 && !visited[x][y][power]){
                    if(grid[x][y]==1){
                        if(power>0){
                            q.add(new int[]{x,y,power-1,dist+1});
                            visited[x][y][power]=true;
                        }
                    }else{
                        q.add(new int[]{x,y,power,dist+1});
                        visited[x][y][power]=true;
                    }

                }
            }
        }
        return -1;
    }
}