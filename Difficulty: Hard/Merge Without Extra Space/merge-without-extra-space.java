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
    // Function to merge the arrays.
    public void mergeArrays(int a[], int b[]) {
        
        //size of given two array.
        int n = a.length;
        int m = b.length;
        
        //i solve this question using extra-space.
        //creating that array that store all element.
        int ans[] = new int[n + m];
        
        //creaing three pointers i ==> a, j ==> b, and k ==>ans
        int i= 0;
        int j = 0;
        int k = 0;
        
        while(i < n && j < m)
            if(a[i] < b[j]) ans[k++]  = a[i++];
            else ans[k++] = b[j++];
        
        //if array a is pending to fill in array 'ans'
        while(i < n) ans[k++] = a[i++];
        
        //if array b is pending to fill in array 'ans[]'
        while(j < m) ans[k++] = b[j++];
        
        //pointer for the 'a[]' array.
        int pa = 0;
        //pointer for the 'b[]' array.
        int pb = 0;
        //pointer for the 'ans[]' array.
        int pans = 0;
        
        //fill the array a
        while(pa < n)
        {
            a[pa++] = ans[pans++];
        }
        
        //fill the array b
        while(pb < m)
        {
            b[pb++] = ans[pans++];
        }
        
        
        
    }
}
