//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestCommonSubstr(String s, String t) {
         int m = s.length();
        int n = t.length();
        
        int dp[][] =  new int[m + 1][n + 1];
        
        int maxi = Integer.MIN_VALUE;
        
        
        for(int ind1 = 1; ind1 <= m; ind1++)
        {
            for(int ind2 = 1; ind2 <= n; ind2++)
            {
                if(s.charAt(ind1 - 1) == t.charAt(ind2 - 1))
                {
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                }
                else
                {
                    dp[ind1][ind2] = 0;
                }
                
                maxi  = Math.max(maxi, dp[ind1][ind2]);
            }
            
           
        }
        
        return maxi;
    }
}