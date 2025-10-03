class Solution {
    public boolean containsCycle(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visited=new boolean[m][n];
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(!visited[i][j] && isCyclePresent(new int[]{i,j},visited,grid,m,n)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCyclePresent(int[] src,boolean[][] visited,char[][] grid,int m,int n){
        char srcChar=grid[src[0]][src[1]];
        int[] dr={1,-1,0,0};
        int[] dc={0,0,-1,1};
        Queue<int[]> q=new LinkedList<>();
        visited[src[0]][src[1]]=true;
        q.add(new int[]{src[0],src[1],-1,-1});
        while(!q.isEmpty()){
            int[] cur=q.remove();
            for(int i=0;i<4;++i){
                int x=cur[0]+dr[i];
                int y=cur[1]+dc[i];
                if(x>=0 && x<=m-1 && y>=0 && y<=n-1 && grid[x][y]==srcChar){
                    if(!visited[x][y]){
                        q.add(new int[]{x,y,cur[0],cur[1]});
                        visited[x][y]=true;
                    }else{
                        if(x!=cur[2] || y!=cur[3]){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}