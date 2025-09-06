class Graph{
    Map<Integer,LinkedList<int[]>> adj=new HashMap<>();
    public void addEdge(int src,int dest,int weight){
        adj.computeIfAbsent(src,key->new LinkedList<>()).add(new int[]{dest,weight});
    }
    public LinkedList<int[]> getAdjacentNodes(int src){
        return adj.getOrDefault(src,new LinkedList<>());
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Graph g=new Graph();
        for(int i=0;i<times.length;++i){
            g.addEdge(times[i][0],times[i][1],times[i][2]);
        }
        return getMinimumDistFromKtoAllNodes(k,n,g);
    }

    public int getMinimumDistFromKtoAllNodes(int src,int n,Graph g){
        int[] dist=new int[n+1];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        pq.add(new int[]{0,src});
        while(!pq.isEmpty()){
            int[] cur=pq.remove();
            if(cur[0]>dist[cur[1]]){
                continue;
            }
            for(int[] adjNode:g.getAdjacentNodes(cur[1])){
                int adjVal=adjNode[0];
                int adjWeight=adjNode[1];
                if((cur[0]+adjWeight)<dist[adjVal]){
                    dist[adjVal]=cur[0]+adjWeight;
                    pq.add(new int[]{dist[adjVal],adjVal});
                }
            }
        } 
        int max=0;
        for(int i=1;i<=n;++i){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
            max=Math.max(max,dist[i]);
        }
        return max;       
    }
}