class Solution {
    public long numberOfWays(String s) {
        int n=s.length();
        int[] pre_z=new int[n];
        int[] suf_z=new int[n];
        int[] pre_o=new int[n];
        int[] suf_o=new int[n];
        for(int i=0;i<n;++i){
            if(s.charAt(i)=='0'){
                pre_z[i]=(i==0)?1:(pre_z[i-1]+1);
            }else{
                pre_z[i]=(i==0)?0:pre_z[i-1];;
            }
        }
        for(int i=0;i<n;++i){
            if(s.charAt(i)=='1'){
                pre_o[i]=(i==0)?1:(pre_o[i-1]+1);
            }else{
                pre_o[i]=(i==0)?0:pre_o[i-1];
            }
        }
        for(int i=n-1;i>=0;--i){
            if(s.charAt(i)=='0'){
                suf_z[i]=(i==n-1)?1:(suf_z[i+1]+1);
            }else{
                suf_z[i]=(i==n-1)?0:suf_z[i+1];
            }
        }
        for(int i=n-1;i>=0;--i){
            if(s.charAt(i)=='1'){
                suf_o[i]=(i==n-1)?1:(suf_o[i+1]+1);
            }else{
                suf_o[i]=(i==n-1)?0:suf_o[i+1];
            }
        }
        long ans=0L;
        for(int i=1;i<n-1;++i){
            if(s.charAt(i)=='1'){
                ans+=(1L*pre_z[i-1]*suf_z[i+1]);
            }else{
                ans+=(1L*pre_o[i-1]*suf_o[i+1]);
            }
        }
        return ans;
    }
}