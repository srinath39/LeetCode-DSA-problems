class Graph {
    HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();

    public void addEdge(int src, int dest) {
        map.computeIfAbsent(src, key -> new LinkedList<>()).add(dest);
        map.computeIfAbsent(dest, key -> new LinkedList<>()).add(src);
    }

    public LinkedList<Integer> getAdjacentNodes(int src) {
        return map.getOrDefault(src, new LinkedList<>());
    }
}

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        Graph g = new Graph();
        for (int i = 0; i < dislikes.length; ++i) {
            g.addEdge(dislikes[i][0], dislikes[i][1]);
        }
        int[] visited=new int[n+1];
        for(int i=1;i<=n;++i){
            if(visited[i]==0 && !isBipartiteGraph(i,g,visited)){
                return false;
            }
        }
        return true;
    }

    public boolean isBipartiteGraph(int src, Graph g,int[] visited){
        Queue<Integer> q= new LinkedList<>();
        q.add(src);
        visited[src]=-1;
        while(!q.isEmpty()){
            int cur=q.remove();
            for(int adj:g.getAdjacentNodes(cur)){
                if(visited[adj]==0){
                    visited[adj]=-visited[cur];
                    q.add(adj);
                }else{
                    if(visited[adj]==visited[cur]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}