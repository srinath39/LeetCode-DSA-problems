class Graph{
    public HashMap<Integer,LinkedList<Integer>> map=new HashMap<>();

    public void addEdge(int src, int dest){
        map.computeIfAbsent(src,key->new LinkedList<>()).add(dest);
        map.computeIfAbsent(dest,key->new LinkedList<>()).add(src);
    }

    public LinkedList<Integer> getAdjacentNodes(int src){
        return map.getOrDefault(src,new LinkedList<>());
    }
}

class Solution {
    
    public int[] gardenNoAdj(int n, int[][] paths) {
        Graph g=new Graph();
        for(int i=0;i<paths.length;++i){
            g.addEdge(paths[i][0],paths[i][1]);
        }
        int[] planTypes=new int[n];
        Arrays.fill(planTypes,-1);
        for(int i=1;i<=n;++i){
            if(planTypes[i-1]==-1){
                BFS(i,g,planTypes);
            }
        }
        return planTypes;
    }

    public void BFS(int src, Graph g ,int[] planTypes){
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        planTypes[src-1]=1;
        while(!q.isEmpty()){
            int cur=q.remove();
            for(int adj:g.getAdjacentNodes(cur)){
                if(planTypes[adj-1]==-1){
                    planTypes[adj-1]=planTypes[cur-1]==4?1:planTypes[cur-1]+1;
                    q.add(adj);
                }else{
                    if(planTypes[adj-1]==planTypes[cur-1]){
                        planTypes[adj-1]=planTypes[cur-1]==4?1:planTypes[cur-1]+1;
                    }
                }
            }
        }
    }
}