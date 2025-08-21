class Solution {
    public int maxBalancedShipments(int[] weight) {
        int n=weight.length;
        int count=0;
        int max=0;
        for(int i=0;i<n;i++){
            if(weight[i]>=max){
                max=weight[i];
            }else{
                count++;
                max=0;
            }
        }
        return count;
    }
}