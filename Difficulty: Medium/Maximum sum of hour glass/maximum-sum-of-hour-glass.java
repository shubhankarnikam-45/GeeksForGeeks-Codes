//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s[] = read.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
            int Mat[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String S[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    Mat[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.findMaxSum(N, M, Mat));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    int findSum(int mat[][], int i, int j, int b1, int b2)
    {
        int sum = 0;
        
        while(j <=b2)
        {
            sum+=mat[i][j++];
        }
        return sum;
    }
    int findSum(int mat[][], int i, int j)
    {
        return mat[i][j];
    }
    int findMaxSum(int m, int n, int mat[][]) {
        
        //final answer.
        int ans = -1;
        
        //traversing in 2d array.
        for(int i=0; i<m-2; i++)
        {
            for(int j=0; j<n-2; j++)
            {
                //first sum.
                int s1 = findSum(mat, i, j, i, j+2);
                
                
                //second sum.
                int s2 = findSum(mat, i+1, j+1);
                
                //third sum.
                int s3 = findSum(mat, i+2, j, i+2, j+2);
                
                // System.out.println(s1+" "+s2+" "+s3);
                
                //total.
                int total = s1 + s2 + s3;
                ans  = Math.max(ans, total);
            }
        }
        
        return ans;
    }
};