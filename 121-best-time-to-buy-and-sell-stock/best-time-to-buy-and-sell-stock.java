class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        if(n==1){
            return 0;
        }
        int[] pre=new int[n];
        for(int i=n-1;i>=0;i--){
            if(i+1==n){
                pre[i]=prices[i];
            }else{
                pre[i]=Math.max(prices[i],pre[i+1]);
            }
        }
        int max=0;
        for(int i=0;i<n-1;i++){
            if(prices[i]<pre[i+1]){
                max=Math.max(max,pre[i+1]-prices[i]);
            }
        }
        return max;
    }
    }