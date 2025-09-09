class Solution {
    public static int longestCycle;
    public int longestCycle(int[] edges) {
        longestCycle=-1;
        int n=edges.length;
        int[] visited=new int[n];
        int[] length=new int[n];
        for(int i=0;i<n;++i){
            if(visited[i]==0){
                detectCycle(i,edges,visited,0,length);
            }
        }
        return longestCycle;
    }

    public void detectCycle(int src,int[] edges,int[] visited,int step,int[] length){
        visited[src]=1;
        length[src]=step+1;
        if(edges[src]!=-1){
            int adj=edges[src];
            if(visited[adj]==0){
                detectCycle(adj,edges,visited,length[src],length);
            }else{
                if(visited[adj]==1){
                    longestCycle=Math.max(longestCycle,length[src]-length[adj]+1);
                }
            }
        }
        visited[src]=2;
    } 
}