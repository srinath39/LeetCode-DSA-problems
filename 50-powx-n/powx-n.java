class Solution {
    public double myPow(double x, int n) {
        int isNegative= x<0 && n%2!=0 ? -1:1;
        double xPowN= X_Power_N((double)Math.abs(x),(int)Math.abs(n));
        return isNegative *(n<0?((double)1)/xPowN:xPowN);
    }

    public double X_Power_N(double x,int n){
        if(n==0){
            return 1.0;
        }
        double Y=X_Power_N(x,n/2);
        if(n%2==0){
            return Y*Y;
        }
        return x*Y*Y;
    }
}