class Solution {
    public int minSensors(int n, int m, int k) {
        int size=2*k+1;
        int x=(n+size-1)/size;
        int y=(m+size-1)/size;
        return x*y;
    }
}