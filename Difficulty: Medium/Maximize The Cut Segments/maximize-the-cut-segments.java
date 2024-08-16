//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading length of line segment
            int n = Integer.parseInt(read.readLine().trim());
            
            
            //reading 3 segment lengths
            String str[] = read.readLine().trim().split(" ");
            
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            int z = Integer.parseInt(str[2]);
            
            
            //calling method maximizeCuts() of class Solution()
            //and printinting the result
            System.out.println(new Solution().maximizeCuts(n, x, y, z));
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find the maximum number of cuts.
    public int maximizeCutsH(int n, int p, int x, int y, int z, int dp[])
    {
       
       //base case.
       if(n == 0) return 1;
       
       if(n < 0) return 0;
       
       if(dp[n] != -1) return dp[n];
       
       int a = maximizeCutsH(n-x,p,  x, y, z, dp);
       int b = maximizeCutsH(n-y, p, x, y, z, dp);
       int c = maximizeCutsH(n-z, p, x, y, z, dp);
       
       int maxi = Math.max(a, Math.max(b,c));
       
       if(n == p)
       {
           dp[n] = maxi;
           return maxi;
       }
       
       
       if(maxi != 0) 
       {
           dp[n] = maxi + 1;
           return 1 + maxi;
       }
       
       return 0;
        
    }
    
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
        
        int dp[] = new int[n + 1];
        Arrays.fill(dp , -1);
       
       return maximizeCutsH(n, n, x, y, z, dp);
        
    }
}
