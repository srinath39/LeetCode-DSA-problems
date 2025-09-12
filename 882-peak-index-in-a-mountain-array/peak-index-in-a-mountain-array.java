class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n=arr.length;
        int l=0;
        int r=n-1;
        while(l+1<r){
            int mid=(l+r)/2;
            if((arr[mid]-arr[mid-1])<0){
                r=mid;
            }else{
                l=mid;
            }
        }
        return l;
    }
}