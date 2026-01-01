class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[] visited=new boolean[n+1];
        int count=0;
        for(int i=1;i<=n;++i){
            if(!visited[i]){
                ++count;
                DFS(i,visited,isConnected);
            }
        }
        return count;
    }

    public void DFS(int src,boolean[] visited, int[][] isConnected){
        visited[src]=true;
        for(int i=0;i<isConnected.length;++i){
            if(isConnected[src-1][i]==1 && !visited[i+1]){
                DFS(i+1,visited,isConnected);
            }
        }
    }
    
}