//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) arr[i][j] = sc.nextInt();

            GFG g = new GFG();
            g.rotate(arr);
            printMatrix(arr);

            System.out.println("~");
        }
    }

    static void printMatrix(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) System.out.print(arr[i][j] + " ");
            System.out.println("");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class GFG {
    static void rotate(int mat[][]) {
        
        //size of array (original.)
        int n = mat.length;
        
        //creating arraySize.
        int arraySize = n - 1;
        
        int i = 0;
        
        while(i < n / 2)
        {
            //creating 1D array of size arraysize + 1
            int arr[] = new int[arraySize + 1];
            
            //this pointer attach with the arr.
            int p = 0;
            
            //here we paste the first row into the 'arr'
            for(int j=i; j<= arraySize + i; j++)
            {
                arr[p++] = mat[i][j];
            }
            
            //make p = 0;
            //this is for the right row.
            p=0;
            for(int j=i; j<= arraySize; j++)
            {
                int temp = mat[j][arraySize];
                mat[j][arraySize] = arr[p];
                arr[p++] = temp;
            }
            
            //make p = 0;
            p=0;
            //this is for the bottom row
            for(int j=arraySize; j>=i; j--)
            {
                int temp = mat[arraySize][j];
                mat[arraySize][j] = arr[p];
                arr[p++] = temp;
            }
            
            //make p = 0;
            p=1;
            //this is for the left row
            for(int j=arraySize-1; j>=i; j--)
            {
                int temp = mat[j][i];
                mat[j][i] = arr[p];
                arr[p++] = temp;
            }
            
            //make p = 0;
            p=1;
            //this is for the upper row
            for(int j=i+1; j<= arraySize; j++)
            {
                int temp = mat[i][j];
                mat[i][j] = arr[p];
                arr[p++] = temp;
            }
            
            
            //increase the i pointer.
            i++;
            
            //make the size of array.
            arraySize = arraySize - 1;
            
            
            
        }
        
        
        
    }
}