class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        int[] parent=new int[n+1];
        Arrays.fill(parent,-1);
        for(int i=0;i<n;i++){
            if(merge(edges[i][0],edges[i][1],parent)){
                return new int[]{edges[i][0],edges[i][1]};
            }
        }
        return new int[]{};
    }

    public int findLeader(int v,int[] parent){
        if(parent[v]<0){
            return v;
        }
        return parent[v]=findLeader(parent[v],parent);
    }

    public boolean merge(int a,int b,int[] parent){
        int x,y;
        if((x=findLeader(a,parent))==(y=findLeader(b,parent))){
            return true;
        }
        if(parent[x]>parent[y]){
            int temp=y;
            y=x;
            x=temp;
        }
        parent[x]+=parent[y];
        parent[y]=x;
        return false;
    }

}