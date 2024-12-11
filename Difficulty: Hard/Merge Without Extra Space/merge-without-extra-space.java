//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases

        while (t-- > 0) {
            String arr1[] = br.readLine().trim().split(" ");
            String arr2[] = br.readLine().trim().split(" ");

            int a[] = new int[arr1.length];
            int b[] = new int[arr2.length];

            for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(arr1[i]);
            for (int i = 0; i < b.length; i++) b[i] = Integer.parseInt(arr2[i]);

            Solution ob = new Solution();
            ob.mergeArrays(a, b);

            StringBuffer str = new StringBuffer();
            for (int i = 0; i < a.length; i++) {
                str.append(a[i] + " ");
            }
            System.out.println(str);
            str = new StringBuffer();
            for (int i = 0; i < b.length; i++) {
                str.append(b[i] + " ");
            }
            System.out.println(str);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    //shifting array element.
    public void shiftingArrElement(int arr[], int idx)
    {
        for(int i = arr.length -1 ; i>idx; i--)
        {
            arr[i] = arr[i - 1];
        }
    }
    //code for upperBound.
    public int findIdx(int a[], int t)
    {
        int low = 0;
        int high = a.length -1;
        
        while(low <= high)
        {
            int mid = (low + (high-low)/2);
            
            if(a[mid] > t)
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
    // Function to merge the arrays.
    public void mergeArrays(int a[], int b[]) {
        
        //size of given two array.
        int n = a.length;
        int m = b.length;
        
        //traverse reverse order in array 'b[]'
        for(int i= m - 1; i>=0; i--)
        {
            //finding index in array 'a'
            int reqIndex = findIdx(a, b[i]);
            
            if(reqIndex != n)
            {
                //element insert at index 'j'
                int insertAtJ = a[n - 1];
                
                //shifting element in array.
                shiftingArrElement(a, reqIndex);
                a[reqIndex] = b[i];
                b[i] = insertAtJ;
            }
        }
        
        
    }
}
