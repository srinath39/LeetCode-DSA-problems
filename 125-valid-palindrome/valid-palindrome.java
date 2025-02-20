class Solution {
    public boolean isPalindrome(String s) {
        int n=s.length();
        int i=0;
        int j=n-1;
        while(i<j){
            char c1=s.charAt(i);
            char c2=s.charAt(j);
            if(isAlphaNumeric(c1)&&isOtherChar(c2)){
                j--;
            }
            else if(isOtherChar(c1)&&isAlphaNumeric(c2)){
                i++;
            }
            else{
                if(isAlphaNumeric(c1)&&isAlphaNumeric(c2)){
                    if(!(Character.toLowerCase(c1)==Character.toLowerCase(c2))){
                        return false;
                    }
                }
                i++;
                j--;
            }
        }
        return true;
    }

    public static boolean isAlphaNumeric(char c){
        if(Character.isDigit(c) || Character.isLetter(c)){
            return true;
        }
        return false;
    }

    public static boolean isOtherChar(char c){
        if(Character.isWhitespace(c) || !isAlphaNumeric(c)){
            return true;
        }
        return false;
    }
}