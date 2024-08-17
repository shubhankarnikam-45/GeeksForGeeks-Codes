//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            long[] ans = new long[n];
            ans = ob.productExceptSelf(array);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends

class Solution {
    public static long[] productExceptSelf(int arr[]) {
        int n = arr.length;
        long[] prod = new long[n];

        if (n == 1) {
            prod[0] = 1;
            return prod;
        }

        long temp = 1;

        for (int i = 0; i < n; i++) prod[i] = 1;

        for (int i = 0; i < n; i++) {
            prod[i] = temp;
            temp *= arr[i];
        }

        temp = 1;

        for (int i = n - 1; i >= 0; i--) {
            prod[i] *= temp;
            temp *= arr[i];
        }

        return prod;
    }
}
