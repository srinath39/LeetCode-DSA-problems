class Graph{
    Map<Integer,LinkedList<int[]>> adj=new HashMap<>();
    public void addEdge(int src,int dest,int weight){
        adj.computeIfAbsent(src,key->new LinkedList<>()).add(new int[]{dest,weight});
        adj.computeIfAbsent(dest,key->new LinkedList<>()).add(new int[]{src,weight});
    }
    public LinkedList<int[]> getAdjacentNodes(int src){
        return adj.getOrDefault(src,new LinkedList<>());
    }
}
class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        Graph g=new Graph();
        for(int i=0;i<edges.length;++i){
            g.addEdge(edges[i][0],edges[i][1],edges[i][2]);
        }
        return getMinimumTimeDisappearingNodes(n,g,disappear);
    }

    public int[] getMinimumTimeDisappearingNodes(int n,Graph g,int[] disappear){
        int[] dist=new int[n];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        pq.add(new int[]{0,0});
        while(!pq.isEmpty()){
            int[] cur=pq.remove();
            if(cur[0]>dist[cur[1]]){
                continue;
            }
            for(int[] adjNode:g.getAdjacentNodes(cur[1])){
                int adjVal=adjNode[0];
                int adjWeight=adjNode[1];
                if((cur[0]+adjWeight)<dist[adjVal] && (cur[0]+adjWeight)<disappear[adjVal]){
                        dist[adjVal]=cur[0]+adjWeight;
                        pq.add(new int[]{dist[adjVal],adjVal});
                }
            }
        } 
        for(int i=0;i<n;++i){
            if(dist[i]==Integer.MAX_VALUE){
                dist[i]=-1;
            }
        }
        return dist;   
    }
}