//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    static boolean fun(int idx, int arr[], int sum, int target, int dp[][]) {
        // Base case: If sum equals target, we've found a subset
        if (sum == target) {
            return true;
        }
        // If we've reached the end of the array or the sum exceeds target, return false
        if (idx == arr.length || sum > target) {
            return false;
        }
        // Check memoized results
        if (dp[idx][sum] != -1) {
            return dp[idx][sum] == 1;
        }
        
        // Include current element and exclude it in recursive calls
        boolean include = fun(idx + 1, arr, sum + arr[idx], target, dp);
        boolean exclude = fun(idx + 1, arr, sum, target, dp);
        
        // Memoize the result (1 for true, 0 for false)
        dp[idx][sum] = (include || exclude) ? 1 : 0;
        
        return dp[idx][sum] == 1;
    }
    
    static Boolean isSubsetSum(int N, int arr[], int sum) {
        int dp[][] = new int[N][sum + 1];
        // Initialize dp with -1 indicating no computation done yet
        for (int[] brr : dp) {
            Arrays.fill(brr, -1);
        }
        // Start recursion
        return fun(0, arr, 0, sum, dp);
    }
}
