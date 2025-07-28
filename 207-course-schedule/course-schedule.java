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
       for(int i=0;i<prerequisites.length;i++){
            g.addEdge(prerequisites[i][1],prerequisites[i][0]);
       }
       int[] visited=new int[numCourses];
       for(int i=0;i<numCourses;i++){
        if(visited[i]==0){
            if(isCoursesCanbeFinished(i,visited,g)){
                return false;
            }
        }
       }
       return true;
    }

    public boolean isCoursesCanbeFinished(int src,int[] visited,Graph g){
        visited[src]=1;
        for(int ele:g.getAdjacentNodes(src)){
            if(visited[ele]==0){
                if(isCoursesCanbeFinished(ele,visited,g)){
                    return true;
                }
            }else{
                if(visited[ele]==1){
                    return true;
                }
            }
        }
        visited[src]=2;
        return false;
    }
}