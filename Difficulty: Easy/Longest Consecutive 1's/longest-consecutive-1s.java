//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution{
    
    /*  Function to calculate the longest consecutive ones
    *   N: given input to calculate the longest consecutive ones
    */
    public static int maxConsecutiveOnes(int N) {
        
        int n = N;
        String str ="";
        
        while(n!= 1)
        {
            int rem = n % 2;
            str = rem + str;
            n = n/2;
        }
        
        str = n + str;
        
        int ans = Integer.MIN_VALUE;
        
        
        int cnt = 0;
        for(int i=0; i<str.length() ;i++)
        {
            if(str.charAt(i) == '1')
            {
                cnt++;
            }
            else if(cnt != 0)
            {
                ans = Math.max(cnt, ans);
                cnt = 0;
            }
        }
        
        if(cnt != 0)
        {
            ans = Math.max(cnt, ans);
        }
        
        return ans;
        
    }
}



//{ Driver Code Starts.

class Main {
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();//testcases
		while(t-->0){
		    int n = sc.nextInt();//input n
		    
		    Solution obj = new Solution();
		    
		    //calling maxConsecutiveOnes() function
		    System.out.println(obj.maxConsecutiveOnes(n));
		}
	}
}



// } Driver Code Ends