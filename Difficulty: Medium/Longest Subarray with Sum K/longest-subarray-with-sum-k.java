//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int k = Integer.parseInt(read.readLine().trim()); // Read target sum

            Solution ob = new Solution();
            int ans = ob.longestSubarray(nums, k); // Call the function and store result
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestSubarray(int[] a, int k) {
         //size of array.
        int n = a.length;

         //the variable where we stor our answer.
         int maxLen = 0;

        //hashmap.
        Map<Long, Integer> map = new HashMap<>();

        //sum variable to store the sum.
        long sum = 0;
        //traverse array 
        for(int i=0; i<n; i++)
        {
            //each time we added current element to the sum
            sum += a[i];

            //if we found the current sum == k
            if(sum == k) maxLen = Math.max(maxLen, i + 1);
            if(map.containsKey(sum - k) == true)
            {
                //if found the sum-k in the hashmap.
                int idx = map.get(sum - k);

                //we compare with the maxLen
                maxLen = Math.max(maxLen, i - idx);
            }

            //we added current sum and the index to the hashmap 
            //if ans only if it not present previously.
            if(!map.containsKey(sum)) map.put(sum, i);
        }
        
         return maxLen;
    }
}
