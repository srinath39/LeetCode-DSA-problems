class Solution {
    public boolean areOccurrencesEqual(String s) {
        char[] arr=new char[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-97]++;
        }
        int check=arr[s.charAt(0)-97];
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0&&arr[i]!=check){
                return false;
            }
        }
        return true;
    }
}