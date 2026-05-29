class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        for(int[] p:points){
            pq.add(new int[]{p[0],p[1],(p[0]*p[0])+(p[1]*p[1])});
        }
        int[][] ans=new int[k][2];
        for(int i=0;i<k;++i){
            int[] cur=pq.remove();
            ans[i][0]=cur[0];
            ans[i][1]=cur[1];
        }
        return ans;
    }
}