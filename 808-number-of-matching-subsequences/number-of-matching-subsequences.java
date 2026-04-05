class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<Character,ArrayList<Integer>> map=new HashMap<>();
        for(int i=0;i<s.length();++i){
            map.computeIfAbsent(s.charAt(i),key->new ArrayList<>()).add(i);
        }
        int count=0;
        for(int i=0;i<words.length;++i){
            int prev=-1;
            for(int j=0;j<words[i].length();++j){
                char ch=words[i].charAt(j);
                if(map.containsKey(ch)){
                    int newIndex=getIndexGreaterThanPrev(map.get(ch),prev);
                    if(newIndex==-1 || newIndex<=prev){
                        prev=-1;
                        break;
                    }
                    prev=newIndex;
                }else{
                    prev=-1;
                    break;
                }
            }
            if(prev!=-1){
                ++count;
            }
        }
        return count;
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