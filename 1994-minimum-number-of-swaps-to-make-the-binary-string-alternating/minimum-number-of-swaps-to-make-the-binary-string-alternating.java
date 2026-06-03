class Solution {
    public int minSwaps(String s) {
        int f0=0;
        int f1=0;
        for(int i=0;i<s.length();++i){
            if(s.charAt(i)=='0'){
                ++f0;
            }else{
                ++f1;
            }
        }
        if(Math.abs(f0-f1)>1){
            return -1;
        }

        int f0v=countVoilators(s,'0');
        int f1v=countVoilators(s,'1');
        if(f0==f1){
            return Math.min(f0v,f1v)/2;
        }
        if(f0>f1){
            return f0v/2;
        }
        return f1v/2;
    }

    public int countVoilators(String s,char start){
        int c=0;
        for(int i=0;i<s.length();++i){
            char ch=s.charAt(i);
            if(ch!=start){
                ++c;
            }
            if(start=='0'){
                start='1';
            }else{
                start='0';
            }
        }
        return c;
    }
}