class Solution {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()){
            return true;
        }
        int n=s.length();
        int i=0;
        int j=n-1;
        while(i<j){
            char c1=s.charAt(i);
            char c2=s.charAt(j);
            if(!(Character.isDigit(c1) || Character.isLetter(c1))){
                i++;
            }
            else if(!(Character.isDigit(c2) || Character.isLetter(c2))){
                j--;
            }
            else{
                    if(!(Character.toLowerCase(c1)==Character.toLowerCase(c2))){
                        return false;
                    }
                i++;
                j--;
            }
        }
        return true;
    }
}