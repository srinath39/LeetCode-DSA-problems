class Solution {

     static class Graph{
        HashMap<Integer,LinkedList<Integer>> adj=null;
        public Graph(){
            adj=new HashMap<>();
        }
        public void addEdge(int u,int v){
            adj.computeIfAbsent(u,key->new LinkedList<>()).add(v);
        }
        public LinkedList<Integer> getAdjacentNodes(int src){
            return adj.getOrDefault(src,new LinkedList<>());
        }

    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       Graph g=new Graph();
       int[] indegree=new int[numCourses];
       for(int i=0;i<prerequisites.length;i++){
            g.addEdge(prerequisites[i][1],prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
       }
       return isCoursesCanbeFinished(indegree,g,numCourses);
    }

     public boolean isCoursesCanbeFinished(int[] indegree,Graph g,int n){
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int k=0;
        while(!q.isEmpty()){
            int cur=q.remove();
            ++k;
            for(int ele:g.getAdjacentNodes(cur)){
                --indegree[ele];
                if(indegree[ele]==0){
                    q.add(ele);
                }
            }
        }
        return k==n? true:false;
    }

 
}