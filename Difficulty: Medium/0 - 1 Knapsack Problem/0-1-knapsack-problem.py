#User function Template for python3
class Solution:
    
    #Function to return max value that can be put in knapsack of capacity W.
    def get_ans(self, w, idx, wt, val, n, memo):
        if idx < 0:
            return 0
        if memo[idx][w] != -1:
            return memo[idx][w]
        
        a = 0
        if w - wt[idx] >= 0:
            a = val[idx] + self.get_ans(w - wt[idx], idx - 1, wt, val, n, memo)
        
        a = max(a, self.get_ans(w, idx - 1, wt, val, n, memo))
        memo[idx][w] = a
        
        return memo[idx][w]
        
    def knapSack(self,W, wt, val):
        n = len(wt)
        memo = [[-1] * (W + 1) for _ in range(n)]
        return self.get_ans(W, n - 1, wt, val, n - 1, memo)


#{ 
 # Driver Code Starts
#Initial Template for Python 3
import atexit
import io
import sys

if __name__ == '__main__':
    test_cases = int(input())
    for cases in range(test_cases):
        # n = int(input())
        W = int(input())
        val = list(map(int, input().strip().split()))
        wt = list(map(int, input().strip().split()))
        ob = Solution()
        print(ob.knapSack(W, wt, val))

# } Driver Code Ends