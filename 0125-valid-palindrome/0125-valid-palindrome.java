class Solution {
    public boolean isPalindrome(String s) {
        if(s.equals(" ")){
            return true;
        }
        String str=s.toLowerCase().replaceAll("[^a-z0-9]","");
        int n=str.length();
        if(n==0 || n==1){
            return true;
        }
        int i=0;
        while(i<n/2){
            if(!(str.charAt(i)==str.charAt(n-i-1))){
                return false;
            }
            i++;
        }
        return true;
    }
}