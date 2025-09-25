class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m=isWater.length;
        int n=isWater[0].length;
        Queue<int[]> q=new LinkedList<>();
        int[][] height=new int[m][n];
        for(int[] dist:height){
            Arrays.fill(dist,-1);
        }   
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(isWater[i][j]==1){
                    q.add(new int[]{i,j});
                    height[i][j]=0;
                }
            }
        }

        // Multi-source BFS
        int[] dr={-1,1,0,0};
        int[] dc={0,0,1,-1};
        while(!q.isEmpty()){
            int[] cur=q.remove();
            for(int i=0;i<4;++i){
                int x=cur[0]+dr[i];
                int y=cur[1]+dc[i];
                if(x>=0 && x<=m-1 && y>=0 && y<=n-1 && height[x][y]==-1){
                    q.add(new int[]{x,y});
                    height[x][y]=height[cur[0]][cur[1]]+1;
                }
            }
        }
        return height;
    }
}