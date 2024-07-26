//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res = obj.minimizeCost(arr, N, K);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    public int minimizeCostHelper(int arr[], int idx , int k, int dp[])
    {
        //base case.
        if(idx == 0) return 0;
        
        if(dp[idx] != -1) return dp[idx];
        
        int ans = Integer.MAX_VALUE;
        for(int i=1; i<=k; i++)
        {
            int diff = Integer.MAX_VALUE;
            if(idx - i >=0)
            {
                diff = Math.abs(arr[idx] - arr[idx-i]);
            }
            else
            {
                break;
            }
            ans = Math.min(minimizeCostHelper(arr, idx - i, k, dp) + diff, ans);
            dp[idx] = ans;
        }
        
        return ans;
    }
    
    public int minimizeCost(int arr[], int N, int K) {
        
        int dp[] = new int[N];
        dp[0] = 0;
        Arrays.fill(dp, -1);
        
        return minimizeCostHelper(arr, N-1, K, dp);
    }
}
