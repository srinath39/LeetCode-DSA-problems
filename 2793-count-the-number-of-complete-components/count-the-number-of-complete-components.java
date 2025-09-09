class Solution {
    public static Map<Integer,LinkedList<Integer>> map=null;
    public void loadGraphData(int V,int[][] edges){
        map=new HashMap<>();
        for(int i=0;i<V;i++){
            map.put(i,new LinkedList<>());
        }
        for(int i=0;i<edges.length;i++){
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        loadGraphData(n,edges);
        int count=0;
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i] && isCompleteConnectedComponent(i,visited)){
                ++count;
            }
        }
        return count;
    }

    public boolean isCompleteConnectedComponent(int src,boolean[] visited){
        int no_of_nodes=0;
        int no_of_edges=0;
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        visited[src]=true;
        while(!q.isEmpty()){
            int cur=q.remove();
            ++no_of_nodes;
            for(int ele:map.get(cur)){
                ++no_of_edges;
                if(!visited[ele]){
                    visited[ele]=true;
                    q.add(ele);
                }
            }
        }
        if((no_of_nodes*(no_of_nodes-1))==no_of_edges){
            return true;
        }
        return false;
    }
}