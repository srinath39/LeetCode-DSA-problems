class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
        int l=-1;
        int r=n;
        while(l+1<r){
            int mid=(l+r)/2;
            if(predicate(citations,mid,n)==0){
                l=mid;
            }
            else{
                r=mid;
            }
        }
        if(r==n){
            return 0;
        }
        return n-r;
    }

    public int predicate(int[] arr,int mid,int n){
        int h=n-mid;
        if(arr[mid]<h){
            return 0;
        }
        return 1;
    }
}