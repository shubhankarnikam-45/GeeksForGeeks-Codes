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
            int A = obj.minIncrements(a);
            System.out.println(A);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int minIncrements(int[] arr) {
        
        //sort the array.
        Arrays.sort(arr);
        
        //size of arrayl.
        int n = arr.length;
        
        //creating HashSet.
        // HashSet<Integer> hset = new HashSet<>();
        boolean hset[] = new boolean[1000000 + 1];
        
        //adding first element of array in the hset.
        hset[arr[0]] = true;
        
        //total operation count variable.
        int totalOperation = 0;
        
        //now we start for loop from the first index of array.
        for(int i=1; i<n; i++)
        {
            //current element.
            int currentElement = arr[i];
            
            //if hset contains the current element
            if(hset[currentElement])
            {
                totalOperation += 1;
                
                int j = currentElement + 1;
                
                
                while(true)
                {
                    if(!hset[j]) 
                    {
                        hset[j] = true;
                        break;
                    }
                    else 
                        totalOperation+=1;
                    j++;
                }
            }
            else //if hashset not contains the currment elemnet.
            {
                hset[currentElement] = true;
            }
        }
        
        return totalOperation;
    }
}