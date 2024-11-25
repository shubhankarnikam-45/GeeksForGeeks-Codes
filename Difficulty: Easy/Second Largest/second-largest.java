//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.getSecondLargest(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int getSecondLargest(int[] arr) {
        
        //created two varaible that holds the first max. and second max
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        
        //size of array.
        int n = arr.length;
        
        //traverse array and find the answer.
        for(int i=0; i<n; i++)
        {
            //current element.
            int currentElement = arr[i];
            
            //if current element is greater than the firstMax.
            if(currentElement > firstMax)
            {
                secondMax = firstMax;
                firstMax = currentElement;
            }
            else if(secondMax < currentElement && firstMax != currentElement)//if current element is greater than the second max.
            {
                secondMax = currentElement;
            }
            
        }
        
        
        //if firstMax and secondMax is same then we return -1 as per question.
        if(firstMax == secondMax) return -1;
        
        if(secondMax == Integer.MIN_VALUE) return -1;
        //else we return the secondMax element.
        return secondMax;
    }
}