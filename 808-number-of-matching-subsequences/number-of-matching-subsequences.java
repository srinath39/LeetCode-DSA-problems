class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<Character,ArrayList<Integer>> map=new HashMap<>();
        for(int i=0;i<s.length();++i){
            map.computeIfAbsent(s.charAt(i),key->new ArrayList<>()).add(i);
        }
        int count=0;
        for(int i=0;i<words.length;++i){
            if(processString(words[i],map)){
                ++count;
            }
        }
        return count;
    }

    public boolean processString(String str,HashMap<Character,ArrayList<Integer>> map){
            int prev=-1;
            for(int j=0;j<str.length();++j){
                char ch=str.charAt(j);
                if(map.containsKey(ch)){
                    int newIndex=getIndexGreaterThanPrev(map.get(ch),prev);
                    if(newIndex==-1 || newIndex<=prev){
                       return false;
                    }
                    prev=newIndex;
                }else{
                    return false;
                }
            }
            return true;
    }

    public int getIndexGreaterThanPrev(ArrayList<Integer> arr,int k){
        int n=arr.size();
        int L=-1;
        int R=n;
        while((L+1)<R){
            int mid=(L+R)/2;
            if(arr.get(mid)<=k){
                L=mid;
            }else{
                R=mid;
            }
        }
        if(R==n){
            return -1;
        }
        return arr.get(R);
    }
}