class Solution {
    public String reverseStr(String s, int k) {
        int n=s.length();
        StringBuilder str=new StringBuilder(s);
        int i=0;
        int j=2*k-1;
        while(j<n||(n-i)>=k){    
            reverseString(str,i,i+k-1);
            i=i+(2*k);
            j=j+(2*k);
        }
        if(i<n){
            reverseString(str,i,n-1);
        }
        return str.toString();
    }

    public static void reverseString(StringBuilder str, int a, int b){
        if(a>=b){
            return;
        }
        char temp=(char)str.charAt(a);
        str.setCharAt(a,str.charAt(b));
        str.setCharAt(b,temp);
        reverseString(str,++a,--b);
    }
}