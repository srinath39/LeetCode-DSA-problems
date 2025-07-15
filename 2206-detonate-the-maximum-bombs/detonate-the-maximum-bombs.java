class Solution {
    public int maximumDetonation(int[][] bombs) {
        HashMap<Integer,LinkedList<Integer>> adj=new HashMap<>();
        int n=bombs.length;
        int xi,yi,r,xj,yj,xij,yij;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j!=i){
                    xj=bombs[j][0];
                    yj=bombs[j][1];
                    xi=bombs[i][0];
                    yi=bombs[i][1];
                    r=bombs[i][2];
                    xij=xi-xj;
                    yij=yi-yj;
                    if(((1L*xij*xij)+(1L*yij*yij))<=(1L*r*r)){
                        adj.computeIfAbsent(i+1,key->new LinkedList<>()).add(j+1);
                    }
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            max=Math.max(max,maxNumberOfNodesCoveredWithSrc(i,n,adj));
        }
        return max;
    }

    public int maxNumberOfNodesCoveredWithSrc(int src,int n,HashMap<Integer,LinkedList<Integer>> adj){
        boolean[] visited=new boolean[n+1];
        Queue<Integer> q=new LinkedList<>();
        visited[src]=true;
        q.add(src);
        int count=0;
        while(!q.isEmpty()){
            int cur=q.remove();
            count++;
            if(adj.containsKey(cur)){
                for(int ele:adj.get(cur)){
                if(!visited[ele]){
                    q.add(ele);
                    visited[ele]=true;
                }
                }
            }
        }
        return count;
    }
}