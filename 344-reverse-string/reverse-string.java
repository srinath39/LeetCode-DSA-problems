class Solution {
    public void reverseString(char[] s) {
        if(s.length==1){
            return;
        }
        int n=s.length;
        int i=0;
        char temp;
        while(i<n/2){
            temp=s[i];
            s[i]=s[n-i-1];
            s[n-i-1]=temp;
            i++;
        }
    }
}