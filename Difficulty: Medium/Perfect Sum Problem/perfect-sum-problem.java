//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{

    public int fun(int idx, int target, int arr[], int dp[][])
    {
       if(idx==0)
        {
            if(target==0 && arr[0]==0) return 2;
            if(arr[0]==target || target==0) return 1;
            return 0;
        }
        
        if(dp[idx][target] != -1) return dp[idx][target];
        
        int exclude =  fun(idx - 1, target, arr, dp);
        
        int include = 0;
        
        if(arr[idx] <= target)
        {
            
            include = fun(idx - 1, target - arr[idx], arr, dp);
        }
            
        
        
        return dp[idx][target] = (exclude + include) % (int)(1e9 + 7);
    }
    
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    
	    int dp[][] = new int[n][sum+1];
	    
	    for(int brr[] : dp) Arrays.fill(brr, -1);
	    
	    return fun(arr.length-1, sum, arr, dp) % (int)(1e9 + 7);
	} 
}