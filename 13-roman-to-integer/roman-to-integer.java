class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int n=s.length();
        int sum =map.get(s.charAt(0));
        if(n==1){
            return sum;
        }
        int prev=sum;
        for(int i=1;i<n;i++){
            int curele=map.get(s.charAt(i));
            if(prev>=curele){
                sum=sum+curele;
            }else{
                sum=sum + curele -(2*prev);
            }
            prev=curele;
        }
        return sum;
    }
}