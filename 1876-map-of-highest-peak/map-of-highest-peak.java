class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m=isWater.length;
        int n=isWater[0].length;
        int[][] height=new int[m][n];
        for(int[] arr: height){
            Arrays.fill(arr,-1);
        }
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(isWater[i][j]==1){
                    q.add(new int[]{i,j});
                    height[i][j]=0;
                }
            }
        }
        int t=0;
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        while(!q.isEmpty()){
            int s=q.size();
            ++t;
            for(int k=0;k<s;++k){
                int[] cur=q.remove();
                for(int i=0;i<4;++i){
                    int x=cur[0]+dx[i];
                    int y=cur[1]+dy[i];
                    if(x>=0 && x<=m-1 && y>=0 && y<=n-1 && height[x][y]==-1){
                        q.add(new int[]{x,y});
                        height[x][y]=t;
                    }
                }
            }
        }
        return height;
    }
}