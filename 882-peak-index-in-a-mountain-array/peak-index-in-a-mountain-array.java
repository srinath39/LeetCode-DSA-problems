class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n=arr.length;
        int[] slope=new int[n-1];
        for(int i=1;i<n;++i){
            slope[i-1]=arr[i]-arr[i-1];
        }

        int l=0;
        int r=n-2;
        while(l+1<r){
            int mid=(l+r)/2;
            if(slope[mid]<0){
                r=mid;
            }else{
                l=mid;
            }
        }
        return r;
    }
}