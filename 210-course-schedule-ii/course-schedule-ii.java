class Solution {
    public static int k;
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
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       Graph g=new Graph();
       for(int i=0;i<prerequisites.length;i++){
            g.addEdge(prerequisites[i][1],prerequisites[i][0]);
       }
       int[] visited=new int[numCourses];
       int[] ans=new int[numCourses];
       k=numCourses-1;
       for(int i=0;i<numCourses;i++){
        if(visited[i]==0){
            if(isCoursesCanbeFinished(i,visited,g,ans)){
                return new int[]{};
            }
        }
       }
       return ans;
    }

     public boolean isCoursesCanbeFinished(int src,int[] visited,Graph g,int[] ans){
        visited[src]=1;
        for(int ele:g.getAdjacentNodes(src)){
            if(visited[ele]==0){
                if(isCoursesCanbeFinished(ele,visited,g,ans)){
                    return true;
                }
            }else{
                if(visited[ele]==1){
                    return true;
                }
            }
        }
        visited[src]=2;
        ans[k--]=src;
        return false;
    }
}