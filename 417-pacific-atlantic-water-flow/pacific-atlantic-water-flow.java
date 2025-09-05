class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        int[][] atlanticCod=getAtlanticCoordinates(m,n);
        int[][] pacificCod=getPacificCoordinates(m,n);
        boolean[][] atlanticVis=BFS(atlanticCod,heights,m,n);
        boolean[][] pacificVis=BFS(pacificCod,heights,m,n);
        List<List<Integer>> ans=new LinkedList<>();
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(atlanticVis[i][j] && pacificVis[i][j]){
                    List<Integer> list=new LinkedList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    public int[][] getAtlanticCoordinates(int m ,int n){
        int[][] atlanticCod=new int[m+n-1][2];
        int k=0;
        for(int i=0;i<n;++i){
            atlanticCod[k][0]=0;
            atlanticCod[k][1]=i;
            ++k;
        }
        for(int j=1;j<m;++j){
            atlanticCod[k][0]=j;
            atlanticCod[k][1]=0;
            ++k;
        }
        return atlanticCod;
    }

    public int[][] getPacificCoordinates(int m,int n){
        int[][] pacificCod=new int[m+n-1][2];
        int k=0;
        for(int i=0;i<n;++i){
            pacificCod[k][0]=m-1;
            pacificCod[k][1]=i;
            ++k;
        }
        for(int j=m-2;j>=0;--j){
            pacificCod[k][0]=j;
            pacificCod[k][1]=n-1;
            ++k;
        }
        return pacificCod;
    }

    public boolean[][] BFS(int[][] ocean,int[][] arr,int m,int n){
        boolean[][] visited=new boolean[m][n];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<ocean.length;++i){
            visited[ocean[i][0]][ocean[i][1]]=true;
            q.add(new int[]{ocean[i][0],ocean[i][1]});
        }
        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};
        while(!q.isEmpty()){
            int[] cur=q.remove();
            for(int i=0;i<4;++i){
                int x=cur[0]+dr[i];
                int y=cur[1]+dc[i];
                if(x>=0 && x<=m-1 && y>=0 && y<=n-1 && !visited[x][y] && arr[x][y]>=arr[cur[0]][cur[1]]){
                    visited[x][y]=true;
                    q.add(new int[]{x,y});
                }
            }
        }
        return visited;
    }
}