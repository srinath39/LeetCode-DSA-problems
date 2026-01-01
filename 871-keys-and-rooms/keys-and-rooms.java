class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean[] visited=new boolean[n];
        visited[0]=true;
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        int count=0;
        while(!q.isEmpty()){
            int cur=q.remove();
            ++count;
            for(int adj:rooms.get(cur)){
                if(!visited[adj]){
                    visited[adj]=true;
                    q.add(adj);
                }
            }
        }
        return count==n?true:false;
    }

}