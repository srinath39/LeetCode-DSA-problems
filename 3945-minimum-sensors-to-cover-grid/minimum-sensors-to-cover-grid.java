class Solution {
    public int minSensors(int n, int m, int k) {
        int size=2*k+1;
        int x=(int)Math.ceil(((double)n)/size);
        int y=(int)Math.ceil(((double)m)/size);
        return x*y;
    }
}