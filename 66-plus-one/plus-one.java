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
                carry=0;
                break;
            }
        }
        if(carry==1){
           int temp[]=new int[digits.length+1];
           temp[0]=1;
           for(int j=0;j<digits.length;j++){
            temp[j+1]=digits[j];
           } 
           return temp;
        }
        return digits;
    }
}