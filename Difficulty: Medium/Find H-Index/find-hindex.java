//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_cases = Integer.parseInt(br.readLine().trim());

        while (test_cases-- > 0) {
            // Read the array from input line
            String[] input = br.readLine().trim().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            // Solution instance to invoke the function
            Solution ob = new Solution();
            int result = ob.hIndex(arr);

            System.out.println(result);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    public int findMax(int arr[])
    {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++)
        {
            max = Math.max(arr[i], max);
        }
        
        return max;
    }
    // Function to find hIndex
    public int hIndex(int[] citations) {
        
        //size of array.
        int n = citations.length;
        
        
        int maxi = 0;
        
        //sort array.
        Arrays.sort(citations);
        
        for(int i=0; i<n; i++)
        {
            int cnt = n - i;
            
            if(cnt <= citations[i])
            {
                maxi = Math.max(maxi, cnt);
            }
        }
        
        
        return maxi;
    }
}