class Solution {
    public static int[] dp;
    public int mincostTickets(int[] days, int[] costs) {
        int n=days.length;
        dp=new int[n];
        dp[0]=Math.min(costs[0],Math.min(costs[1],costs[2]));
        int x,y,z;
        for(int i=1;i<n;++i){
            // 1 day pass
            x=dp[i-1]+costs[0];
            // 7-day pass
            y=binarySearch(days[i],7,days,i)+costs[1];
            // 30-day pass
            z=binarySearch(days[i],30,days,i)+costs[2];
            dp[i]=Math.min(x,Math.min(y,z));
        }
        for(int i=0;i<n;++i){
            System.out.print(dp[i]+" ");
        }
        return dp[n-1];
    }

    public int binarySearch(int cur,int k,int[] days,int cur_index){
        int L=-1;
        int R=cur_index;
        while(L+1<R){
            int m=(L+R)/2;
            if((cur-days[m]+1)<=k){
                R=m;
            }else{
                L=m;
            }
        }
        if(L==-1){
            return 0;
        }
        return dp[L];
    }
}