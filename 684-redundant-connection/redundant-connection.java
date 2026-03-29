class Solution {
    public static int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        parent=new int[n+1];
        Arrays.fill(parent,-1);
        for(int i=0;i<n;++i){
            if(merger(edges[i][0],edges[i][1])){
                return new int[]{edges[i][0],edges[i][1]};
            }
        }
        return new int[]{};
    }

    public boolean merger(int a, int b){
        int x,y;
        if((x=findLeader(a))==(y=findLeader(b))){
            return true;
        }
        if(parent[y]<parent[x]){
            int t=x;
            x=y;
            y=t;
        }
        parent[x]+=parent[y];
        parent[y]=x;
        return false;
    }

    public int findLeader(int x){
        if(parent[x]<0){
            return x;
        }
        return parent[x]=findLeader(parent[x]);
    }
}