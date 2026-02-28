class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int[] indegree=new int[n];
        Map<Integer,LinkedList<Integer>> reverse=new HashMap<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;++i){
            indegree[i]=graph[i].length;
            if(indegree[i]==0){
                q.add(i);
            }
            for(int j=0;j<graph[i].length;++j){
                reverse.computeIfAbsent(graph[i][j],key->new LinkedList<>()).add(i);
            }
        }
        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            int cur=q.remove();
            ans.add(cur);
            if(reverse.containsKey(cur)){
                for(int adj:reverse.get(cur)){
                    --indegree[adj];
                    if(indegree[adj]==0){
                        q.add(adj);
                    }
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}