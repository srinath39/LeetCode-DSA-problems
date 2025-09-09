class Solution {
    public Map<Integer,LinkedList<Integer>> getGraphData(int V,int[][] edges){
        Map<Integer,LinkedList<Integer>> map=new HashMap<>();
        for(int i=0;i<V;i++){
            map.put(i,new LinkedList<>());
        }
        for(int i=0;i<edges.length;i++){
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        return map;
    }

    public int countCompleteComponents(int n, int[][] edges) {
        Map<Integer,LinkedList<Integer>> map=getGraphData(n,edges);
        int count=0;
        boolean[] bool=new boolean[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            if(bool[i]){
                continue;
            }
            int no_of_edges=0;
            int no_of_nodes=0;
            st.push(i);
            while(!st.empty()){
                int val=st.pop();
                if(bool[val]){
                    continue;
                }
                bool[val]=true;
                no_of_nodes++;
                LinkedList<Integer> adjList=map.get(val);
                for(int j=adjList.size()-1;j>=0;j--){
                    int ele=adjList.get(j);
                    no_of_edges++;
                    if(!bool[ele]){
                        st.push(ele);
                    }
                }
            }
            if(((no_of_nodes*(no_of_nodes-1)))==no_of_edges){
                count++;
            }
        }
        return count;
    }
}