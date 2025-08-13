class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int n=boxTypes.length;
        Arrays.sort(boxTypes,new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                return b[1]-a[1];
            }
        });
        int min,count=0;
        for(int i=0;i<n&&truckSize>0;i++){
            min=Math.min(truckSize,boxTypes[i][0]);
            count+=(boxTypes[i][1]*min);
            truckSize-=min;
        }
        return count;
    }
}