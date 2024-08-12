//{ Driver Code Starts
// Initial Template for Java

import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public int SumofMiddleElements(int[] arr1, int[] arr2) {
        
        //total size of arr1 + arr2.
        int n1= arr1.length + arr2.length;
        
        int arr[] = new int[n1];
        
        int i=0;
        int j=0;
        int k=0;
        
        int m = arr1.length;
        int n = arr2.length;
        
        
        while(i < m && j < n)
        {
            if(arr1[i] <= arr2[j]) arr[k++] = arr1[i++];
            else arr[k++] = arr2[j++];
        }
        
        
        
        while(i < m)
        {
            arr[k++] = arr1[i++];
        }
        
        while(j < n) arr[k++] = arr2[j++];
       
        
        return arr[n1/2] + arr[(n1/2)-1];
    }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline
        while (t-- > 0) {
            String[] input1 = sc.nextLine().split(" ");
            int[] arr = new int[input1.length];
            for (int i = 0; i < input1.length; i++) {
                arr[i] = Integer.parseInt(input1[i]);
            }

            String[] input2 = sc.nextLine().split(" ");
            int[] brr = new int[input2.length];
            for (int i = 0; i < input2.length; i++) {
                brr[i] = Integer.parseInt(input2[i]);
            }

            Solution ob = new Solution();
            int res = ob.SumofMiddleElements(arr, brr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends