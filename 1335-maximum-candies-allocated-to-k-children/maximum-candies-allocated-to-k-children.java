class Solution {
    public int maximumCandies(int[] candies, long k) {
        int n=candies.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(max,candies[i]);
        }
        int l=0;
        int r=max+1;
        while(l+1<r){
            int mid=(l+r)/2;
            if(predicate(mid,k,candies,n)==0){
                l=mid;
            }else{
                r=mid;
            }
        }
        return l;
    }

    public int predicate(int m,long k,int[] arr,int n){
        if(max_no_of_people(m,arr,n)<k){
            return 1;
        }
        return 0;
    }

    public long max_no_of_people(int m,int[] arr,int n){
        long count=0;
        for(int i=0;i<n;i++){
            count+=(arr[i]/m);
        }
        return count;
    }
}