class Solution {
    public int[] longestCommonPrefix(String[] words) {
        int n=words.length;
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            if(i+1<n){
                arr[i]=lengthOfCommonPrefix(words[i],words[i+1]);
            }
        }
        int[] suf=new int[n];
        suf[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            suf[i]=Math.max(suf[i+1],arr[i]);
        }

        int[] pre=new int[n];
        pre[0]=arr[0];
        for(int i=1;i<n;i++){
            pre[i]=Math.max(pre[i-1],arr[i]);
        }

        
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            int max=0;
            if(i+1<n){
                max=Math.max(max,suf[i+1]);
            }
            if(i-2>=0){
                max=Math.max(max,pre[i-2]);          
            }
            if(i+1<n && i-1>=0){
                max=Math.max(max,lengthOfCommonPrefix(words[i-1],words[i+1]));
            }
            ans[i]=max;
        }
        return ans;
        
    }

    public int lengthOfCommonPrefix(String str1, String str2){
        int count=0;
        int i=0;
        while(i<str1.length() && i< str2.length()){
            if(str1.charAt(i)==str2.charAt(i)){
                count++;
            }else{
                break;
            }
            i++;
        }
        return count;
    }
}