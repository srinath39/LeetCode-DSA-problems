class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int[][] dist=new int[n][m];
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    queue.add(new int[]{i,j});
                }
            }
        }
        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};
        while(!queue.isEmpty()){
            int sz=queue.size();
            int[] cur=queue.remove();
            for(int j=0;j<4;j++){
                int x=cur[0]+dr[j];
                int y=cur[1]+dc[j];
                if(x>=0 && x<=n-1 && y>=0 && y<=m-1 && mat[x][y]==1){
                    dist[x][y]=dist[cur[0]][cur[1]]+1;
                    mat[x][y]=0;
                    queue.add(new int[]{x,y});
                }
            }
        }
        return dist;
    }
}