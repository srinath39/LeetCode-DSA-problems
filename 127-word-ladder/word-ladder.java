class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        // create a Graph 
        Map<String,ArrayList<String>> adjList=getGraph(wordList);
        // BFS
        HashMap<String,Integer> dist=new HashMap<>();
        Queue<String> queue=new LinkedList<>();
        queue.add(beginWord);
        dist.put(beginWord,0);
        while(!queue.isEmpty()){
            String curStr=queue.remove();
            for(String word: adjList.get(curStr)){
                if(!dist.containsKey(word)){
                    queue.add(word);
                    dist.put(word,dist.get(curStr)+1);
                }
            }
        }
        if(!dist.containsKey(endWord)){
            return 0;
        }
        return dist.get(endWord)+1;
    }

    public Map<String,ArrayList<String>> getGraph(List<String> wordList){
        Map<String,ArrayList<String>> adjList=new HashMap<>();
        for(String word: wordList){
            adjList.put(word,new ArrayList<>());
            loadEdgeNodes(wordList,word,adjList);
        }
        return adjList;
    }

    public void loadEdgeNodes(List<String> wordList,String word,Map<String,ArrayList<String>> adjList){
        int n=word.length();
        for(String str: wordList){
            int count=0;
            for(int i=0;i<n;i++){
                if(word.charAt(i)!=str.charAt(i)){
                    count++;
                }
            }
            if(count==1){
                adjList.get(word).add(str);
            }
        }
    }
}