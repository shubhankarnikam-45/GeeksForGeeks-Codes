//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            int a[] = new int[inputArray.length];

            for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(inputArray[i]);

            Solution ob = new Solution();
            ob.sort012(a);

            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}


// } Driver Code Ends
class Solution {
    //function to swap the two index.
    public void swap(int arr[], int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(int[] arr) {
        
        //here I am using the Dutch flag algorithm.
        //size of array.
        int n = arr.length;
        
        //creaing the three pointer. low, mid and high.
        int low = 0;
        int high = n - 1;
        int mid = 0;
        
        while(low <= high)
        {
            //if arr[low] is 0 then
            if(arr[low] == 0)
            {
                swap(arr, low, mid);
                mid++;
                low++;
            }
            else if(arr[low] == 1)   //arr[low] is 1
            {
                low++;
            }
            else //arr[low] is 2
            {
                swap(arr, low, high);
                high--;
            }
        }
    }
}

//{ Driver Code Starts.
// } Driver Code Ends