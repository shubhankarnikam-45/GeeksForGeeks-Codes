//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String arr[] = br.readLine().split(" ");
            int a[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                a[i] = Integer.parseInt(arr[i]);
            }
            Solution obj = new Solution();
            int f = 0;
            String A = obj.minSum(a);
            System.out.println(A);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    String addString(StringBuilder sum1, StringBuilder sum2)
    {
        
        
        //we pointing the last index of sum1 
        int i = sum1.length()-1;
        //now we pointing the last index of sum2
        int j = sum2.length() - 1;
        
         int carry = 0;
         
        StringBuilder result = new StringBuilder();
        while(i >= 0 && j >= 0)
        {
            int num = (sum1.charAt(i) - '0' )  + (sum2.charAt(j) - '0');
            
            //number to add in the result strinbuider.
            int numToAdd = (num  + carry) % 10;
            result.append(numToAdd);
            
            //we required carry for next digit.
            carry = (num + carry)/ 10;
            i--;
            j--;
        }
        
        if(i == 0)
        {
            int num = (sum1.charAt(i) - '0');
            
            //number to add in the result strinbuider.
            int numToAdd = (num  + carry) % 10;
            result.append(numToAdd);
            
            //we required carry for next digit.
            carry = (num + carry)/ 10;
     
        }
        
        if(carry == 1) result.append(1);
        
        
        while(result.length() > 0 && result.charAt(result.length() - 1) =='0') result.deleteCharAt(result.length() -1);
        
        
        return result.reverse().toString();
    }
    String minSum(int[] arr) {
        
        //sort the array.
        Arrays.sort(arr);
        
        //here we store the two sum of number
        StringBuilder sum1 = new StringBuilder();
        StringBuilder sum2 = new StringBuilder();
        
        
        for(int i=0; i<arr.length; i++)
        {
            if(i % 2 == 0)
            {
                // if(arr[i] != 0)
                sum1.append(arr[i]);
            }
            else
            {
                // if(arr[i] != 0)
                sum2.append(arr[i]);
            }
        }
        
        
        return addString(sum1, sum2);
    }
}
