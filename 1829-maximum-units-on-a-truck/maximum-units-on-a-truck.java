class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(int[] entry :boxTypes){
            pq.add(entry);
        }
        int maxUnits=0;
        while(truckSize>0 && !pq.isEmpty()){
            int[] cur=pq.remove();
            int tb=Math.min(truckSize,cur[0]);
            maxUnits+=(tb*cur[1]);
            truckSize-=tb;
        }
        return maxUnits;
    }
}