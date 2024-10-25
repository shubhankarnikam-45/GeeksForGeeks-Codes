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
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.longestIncreasingSubsequence(N, arr);
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i) + " ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    public ArrayList<Integer> longestIncreasingSubsequence(int n, int arr[]) {
        
        ArrayList<Integer> alist = new ArrayList<>();
        
        int lastIndex = 0;
        int maxi = 1;
        
        int dp[] = new int[n];
        int hash[] = new int[n];
        
        for(int i=0; i<n; i++)
        {
            dp[i] = 1;
            hash[i] = i;
            for(int j = 0; j<= i -1; j++)
            {
                if(arr[j] < arr[i] && 1 + dp[j] > dp[i])
                {
                    dp[i] = 1 + dp[j];
                    hash[i] = j;
                }
            }
            
            if(dp[i] > maxi)
            {
                maxi = dp[i];
                lastIndex = i;
            }
            
        }
        
        alist.add(arr[lastIndex]);
        
        while(lastIndex != hash[lastIndex])
        {
            lastIndex = hash[lastIndex];
            alist.add(arr[lastIndex]);
            
        }
        
     
        
        
      Collections.reverse(alist);
      return alist;
    }
}
