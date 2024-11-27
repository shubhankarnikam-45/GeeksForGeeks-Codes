//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Reading number of test cases (t)
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // Read the line of integers (prices)
            String input = br.readLine().trim();

            // Split the input line into integers and store in an array
            String[] tokens = input.split(" ");
            int[] arr = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            // Create an instance of the Solution class
            Solution ob = new Solution();

            // Call the missingNumber method
            int res = ob.missingNumber(arr);

            // Print the result
            System.out.println(res);

            // Print the "~" symbol to match the original output
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to find the smallest positive number missing from the array.
    public int missingNumber(int[] arr) {
        
        //size of array.
        int n = arr.length;
        
        //creating hashset 
        Set<Integer> hset = new HashSet<>();
        
        //traverse array and add only positive integers.
        for(int i=0; i<n; i++) if(arr[i] >=1) hset.add(arr[i]);
        
        //now we start from one & if we not found current number in hset.
        //then we return the missing number as answer.
        
        int start = 1;
        while(true)
        {
            if(hset.contains(start) == false) return start;
            start++;
        }
        
        // return -1;
    }
}
