class Graph{
    Map<Integer,LinkedList<int[]>> adj=new HashMap<>();
    public void addEdge(int src,int dest,int weight){
        adj.computeIfAbsent(src,key->new LinkedList<>()).add(new int[]{dest,weight});
        adj.computeIfAbsent(dest,key->new LinkedList<>()).add(new int[]{src,weight});
    }
    public LinkedList<int[]> getAdjcentNodes(int src){
        return adj.getOrDefault(src,new LinkedList<>());
    }
}
class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        Graph g=new Graph();
        int m=edges.length;
        for(int i=0;i<m;++i){
            g.addEdge(edges[i][0],edges[i][1],edges[i][2]);
        }
        int[] minTimeTraversal=Dijkstra(0,g,n,disappear);
        for(int i=0;i<n;++i){
            if(minTimeTraversal[i]==Integer.MAX_VALUE){
                minTimeTraversal[i]=-1;
            }
        }
        return minTimeTraversal;
    }

    public int[] Dijkstra(int src,Graph g,int n,int[] disappear){
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,src});
        dist[src]=0;
        while(!pq.isEmpty()){
            int[] cur=pq.remove();
            if(cur[0]>dist[cur[1]]){
                continue;
            }
            for(int[] adjNode:g.getAdjcentNodes(cur[1])){
                int adjVal=adjNode[0];
                int adjWeight=adjNode[1];
                if(((cur[0]+adjWeight)<dist[adjVal]) && (cur[0]+adjWeight)<disappear[adjVal]){
                    dist[adjVal]=cur[0]+adjWeight;
                    pq.add(new int[]{dist[adjVal],adjVal});
                }
            }
        }
        return dist;
    }
}