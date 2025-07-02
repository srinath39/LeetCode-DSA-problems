class Solution {
    public boolean isBipartite(int[][] graph) {
        return isBipartiteGraph(graph.length,graph);
    }

    public boolean isBipartiteGraph(int V,int[][] graph) {
        int[] color=new int[V];
        for(int i=0;i<V;i++){
            if(color[i]==0){
                if(!isComponentABipartite(i,color,-1,graph)){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isComponentABipartite(int src,int[] color,int cur_color,int[][] graph){
        color[src]=cur_color;
        for(int i=0;i<graph[src].length;i++){
            int ele=graph[src][i];
            if(color[ele]==0){
                if(!isComponentABipartite(ele,color,-cur_color,graph)){
                    return false;
                }
            }else{
                if(color[ele]==color[src]){
                    return false;
                }
            }
        }
        return true;
    }
}