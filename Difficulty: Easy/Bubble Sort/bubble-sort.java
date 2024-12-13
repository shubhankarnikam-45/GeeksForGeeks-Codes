//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    
    //logic of swap.
    public static void swap(int i, int j, int arr[])
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    // Function to sort the array using bubble sort algorithm.
    public static void bubbleSort(int arr[]) {
        
        //size of array.
        int n = arr.length;
        
        for(int itr = 1; itr <= n -1; itr++)
        {
            for(int i = 0; i< n - itr; i++)
            {
                if(arr[i] > arr[i + 1]) swap(i, i + 1, arr);
            }
        }
    }
}

//{ Driver Code Starts.

class Sorting {
    // method to print the Elements of the array
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            // calling bubbleSort() method
            new Solution().bubbleSort(arr);

            // calling printArray() method
            printArray(arr);

            t--;
        }
    }
}
// } Driver Code Ends