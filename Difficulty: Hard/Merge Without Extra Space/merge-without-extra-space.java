//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.io.*;

public class Main
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int m = Integer.parseInt(inputLine[1]);
		    long arr1[] = new long[n];
		    long arr2[] = new long[m];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr1[i] = Long.parseLong(inputLine[i]);
		    }
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<m; i++){
		        arr2[i] = Long.parseLong(inputLine[i]);
		    }
		    Solution ob = new Solution();
		    ob.merge(arr1, arr2, n, m);
		    
		    StringBuffer str = new StringBuffer();
		    for(int i=0; i<n; i++){
		        str.append(arr1[i]+" ");
		    }
		    for(int i=0; i<m; i++){
		        str.append(arr2[i]+" ");
		    }
		    System.out.println(str);
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to merge the arrays.
    public static void merge(long nums1[], long nums2[], int m, int n) 
    {
         //brute force.
        //created array of size n + m
        long arr[] = new long[n+m];

        int i=0;
        int j=0;

        //this for the arr.
        int idx = 0;

        //logic of sort. 2 sorted array.
        while(i<m && j<n)
        {
            if(nums1[i] < nums2[j])
            {
                arr[idx++] = nums1[i++];
            }
            else
            {
                arr[idx] = nums2[j];
                j++;
                idx++;
            }
        }

        while(i < m) arr[idx++] = nums1[i++]; 
        while(j < n) arr[idx++] = nums2[j++];


        for(int k=0; k<n+m; k++)
        {
            if(k<m)
            {
                nums1[k] = arr[k];
            }
            else
            {
                nums2[k-m] = arr[k];
            }
        }
    }
}
