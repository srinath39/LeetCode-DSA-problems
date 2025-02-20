class Solution {
    public int fib(int n) {
        double sqrt5=Math.sqrt(5);
        double dividend=Math.pow((1+sqrt5)/2,n)-Math.pow((1-sqrt5)/2,n);
        return (int)(dividend/sqrt5);
    }
}