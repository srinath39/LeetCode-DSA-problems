class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        Queue<int[]> q=new LinkedList<>();
        boolean[][] visited=new boolean[m][n];
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(board[i][j]=='O' && isBorderCordinate(i,j,m,n)){
                    q.add(new int[]{i,j});
                    visited[i][j]=true;
                }
            }
        }
        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};
        while(!q.isEmpty()){
            int[] cur=q.remove();
            for(int i=0;i<4;++i){
                int x=cur[0]+dr[i];
                int y=cur[1]+dc[i];
                if(x>=0 && x<=m-1 && y>=0 && y<=n-1 && !visited[x][y] && board[x][y]=='O'){
                    visited[x][y]=true;
                    q.add(new int[]{x,y});
                }
            }
        }

        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(board[i][j]=='O' && !visited[i][j]){
                    board[i][j]='X';
                }
            }
        }
    }

    public boolean isBorderCordinate(int i,int j,int m,int n){
        if(i==0 || i==m-1 || j==0 || j==n-1){
            return true;
        }
        return false;
    }
}