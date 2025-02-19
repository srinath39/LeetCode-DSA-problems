class Solution {
    public int reverse(int x) {
        int n;
        boolean negative=false;
        if(x<0){
            n=-x;
            negative=true;
        }else
            n=x;
        int l=(int)Math.log10(n);
        long val=0;
        int r;
        while(n>0){
            r=n%10;
            val=val+(int)(r*Math.pow(10,l));
            n=n/10;
            l=l-1;
        }
        if(negative)
            val=-val;
        if(Integer.MIN_VALUE<=val&& val<=Integer.MAX_VALUE){
            return (int)val;
        }else{
            return 0;
        }
    }
}