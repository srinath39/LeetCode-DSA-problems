class Solution {
    public boolean equationsPossible(String[] equations) {
        int n=equations.length;
        ArrayList<char[]> equalsStrings=new ArrayList<>();
        ArrayList<char[]> notEqualsString=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(equations[i].charAt(1)=='!'){
                notEqualsString.add(new char[]{equations[i].charAt(0),equations[i].charAt(3)});
            }else{
                equalsStrings.add(new char[]{equations[i].charAt(0),equations[i].charAt(3)});
            }
        }

        int[] parent=new int[26];
        Arrays.fill(parent,-1);
        for(int i=0;i<equalsStrings.size();i++){
            merge(equalsStrings.get(i)[0]-97,equalsStrings.get(i)[1]-97,parent);
        }


        for(int i=0;i<notEqualsString.size();i++){
            if(findLeader(notEqualsString.get(i)[0]-97,parent)==findLeader(notEqualsString.get(i)[1]-97,parent)){
                return false;
            }
        }

        return true;

    }

    public int findLeader(int v,int[] parent){
        if(parent[v]<0){
            return v;
        }
        return parent[v]=findLeader(parent[v],parent);
    }

    public void merge(int x,int y,int[] parent){
        if((x=findLeader(x,parent))!=(y=findLeader(y,parent))){
            if(parent[x]>parent[y]){
                int temp=x;
                x=y;
                y=temp;
            }
            parent[x]+=parent[y];
            parent[y]=x;
        }
    }
}