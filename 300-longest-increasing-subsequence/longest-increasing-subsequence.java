class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n];
        int p=0;
        arr[p++]=nums[0];
        for(int i=1;i<n;++i){
            int ele=arr[p-1];
            if(ele<nums[i]){
                arr[p++]=nums[i];
            }else{
                setElementInList(arr,nums[i],p);
            }
        }
        return p;
    }

    public void setElementInList(int[] arr,int k,int p){
        int L=-1;
        int R=p-1;
        while((L+1)<R){
            int m=(L+R)/2;
            if(arr[m]<k){
                L=m;
            }else{
                R=m;
            }
        }
        arr[R]=k;
    }
}