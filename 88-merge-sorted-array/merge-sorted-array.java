class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp=new int[m+n];
        int i=0,j=0,index=0;
        while(i<m&&j<n){
            if(nums1[i]<=nums2[j]){
                temp[index++]=nums1[i];
                i++;
            }
            else{
                temp[index++]=nums2[j];
                j++;
            }
        }
        if(i>=m&&j<n){
            for(int k=j;k<n;k++){
                temp[index++]=nums2[k];
            }
        }else if(j>=n&&i<m){
            for(int l=i;l<m;l++){
                temp[index++]=nums1[l];
            }
        }
        for(int p=0;p<(m+n);p++){
            nums1[p]=temp[p];
        }
    }
}