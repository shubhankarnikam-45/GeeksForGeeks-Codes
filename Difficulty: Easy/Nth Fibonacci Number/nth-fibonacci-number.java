// User function Template for Java

class Solution {
    public int nthFibonacci(int n) {
        //base case.
        if(n == 0) return 0;
        if(n == 1) return 1;
        
        return nthFibonacci(n-1) + nthFibonacci(n-2);
        
    }
}