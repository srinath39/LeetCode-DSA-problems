class Solution {
    public static int[] parent;
    public boolean equationsPossible(String[] equations) {
        int n=equations.length;
        parent=new int[26];
        Arrays.fill(parent,-1);
        for(int i=0;i<n;++i){
            if(equations[i].charAt(1)=='='){
                merge(equations[i].charAt(0)-97,equations[i].charAt(3)-97);
            }
        }

        for(int i=0;i<n;++i){
            if(equations[i].charAt(1)=='!' && findLeader(equations[i].charAt(0)-97)==findLeader(equations[i].charAt(3)-97)){
                return false;
            }
        }
        return true;
    }

    public void merge(int x,int y){
        if((x=findLeader(x))==(y=findLeader(y))){
            return;
        }
        if(parent[y]<parent[x]){
            int t=y;
            y=x;
            x=t;
        }
        parent[x]+=parent[y];
        parent[y]=x;
    }

    public int findLeader(int x){
        if(parent[x]<0){
            return x;
        }
        return parent[x]=findLeader(parent[x]);
    }
}