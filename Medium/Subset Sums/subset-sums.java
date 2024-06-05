//{ Driver Code Starts

// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                arr.add(sc.nextInt());
            }
            Solution ob = new Solution();

            ArrayList<Integer> ans = ob.subsetSums(arr, N);
            Collections.sort(ans);
            for (int sum : ans) {
                System.out.print(sum + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java//User function Template for Java
class Solution {
    
    //final arralist that return answer.
    ArrayList<Integer> ans = new ArrayList<>();
    
    void subsetSumsHelper(ArrayList<Integer> arr, int n, int idx, int sum)
    {
        //base case.
        if(n == idx)
        {
            ans.add(sum);
            return;
        }
        subsetSumsHelper(arr, n, idx+1, sum+arr.get(idx));
        subsetSumsHelper(arr, n, idx+1, sum);
    }
    
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        
        subsetSumsHelper(arr, n, 0, 0); 
        return ans;    
    }
}