class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        // using prefic and suffix 

        // int[] prefixProd=new int[n];
        // prefixProd[0]=nums[0];
        // for(int i=1;i<n;++i){
        //     prefixProd[i]=prefixProd[i-1]*nums[i];
        // }

        // int[] suffixProd=new int[n];
        // suffixProd[n-1]=nums[n-1];
        // for(int i=n-2;i>=0;--i){
        //     suffixProd[i]=suffixProd[i+1]*nums[i];
        // }

        // int leftProd,rightProd;
        // for(int i=0;i<n;++i){
        //     leftProd=i==0?1:prefixProd[i-1];
        //     rightProd=i==n-1?1:suffixProd[i+1];
        //     ans[i]=leftProd*rightProd;
        // }


        ans[0]=1;
        for(int i=1;i<n;++i){
            ans[i]=(ans[i-1]*nums[i-1]);
        }

        int right =1;
        for(int i=n-2;i>=0;--i){
            right*=nums[i+1];
            ans[i]*=right;
        }
        return ans;
    }
}