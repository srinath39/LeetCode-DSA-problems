class Solution {
    public int[] plusOne(int[] digits) {
        int carry=0;
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]==9){
                digits[i]=0;
                carry=1;
            }
            else{
                digits[i]=digits[i]+1;
                return digits;
            }
        }
        if(carry==1){
           int temp[]=new int[digits.length+1];
           temp[0]=1;
           return temp;
        }
        return digits;
    }
}