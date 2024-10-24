//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total testcases
        int t = sc.nextInt();
        while (t > 0) {

            // taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];

            // inserting elements in the array
            for (int i = 0; i < n; ++i) {
                array[i] = sc.nextInt();
            }

            // creating an object of class Solution
            Solution ob = new Solution();

            // calling longestSubsequence() method of class
            // Solution
            System.out.println(ob.longestSubsequence(n, array));
            t--;
        }
    }
}
// } Driver Code Ends




class Solution {
    
    //creating function that gives the lower bound index.
    static int lowerBound(ArrayList<Integer> arr, int n, int target)
    {
        int low = 0;
        int high = n - 1;
        
        while(low <= high)
        {
            int mid = (low + high)/2;
            
            if(arr.get(mid) >= target)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        
        return low;
    }
    static int longestSubsequence(int n, int arr[]) {
        
        //creating arraylist.
        ArrayList<Integer> alist = new ArrayList<>();
        
        for(int i=0; i<n; i++)
        {
            //current element.
            int currElement = arr[i];
            
            int desiredIndex = lowerBound(alist, alist.size(), currElement);
            
            if(desiredIndex <= alist.size() - 1) alist.set(desiredIndex, currElement);
            else alist.add(currElement);
            
        }
        
        return alist.size();
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}