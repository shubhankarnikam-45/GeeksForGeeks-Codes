//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Map.Entry;


// } Driver Code Ends
// User function Template for Java

class Pair implements Comparable<Pair>
{
  int freq;
  int num;
  
  Pair(int freq, int num)
  {
    this.freq = freq;
    this.num = num;
  }
  
  public int compareTo(Pair p)
  {
    return (p.freq > this.freq) ? (1): (-1);
  }
}

class Solution {
    // Function to sort the array according to frequency of elements.
    public ArrayList<Integer> sortByFreq(int arr[]) {
        TreeSet<Pair> pq = new TreeSet<>();
        
        ArrayList<Integer> alist = new ArrayList<>();
        
        //sort array.
        Arrays.sort(arr);
        
        int cnt = 0;
        // traverse from the last of array and store in the pqirotiry queue
        for(int i=arr.length - 1 ; i>=0; i--)
        {
            if(i != 0 && arr[i] == arr[i-1])
            {
                cnt++;
            }
            else
            {
                pq.add(new Pair(cnt + 1, arr[i]));
                cnt = 0;
            }
        }
        
        
        // for(int i=0 ; i < arr.length; i++)
        // {
        //     if(i != arr.length-1 && arr[i] == arr[i+1])
        //     {
        //         cnt++;
        //     }
        //     else
        //     {
        //         pq.add(new Pair(cnt + 1, arr[i]));
        //         cnt = 0;
        //     }
        // }
        
        for(Pair p : pq)
        {
            
            int freq = p.freq;
            int num = p.num;
            
            for(int i=1 ;i<=freq; i++)
            {
                alist.add(num);
            }
        }
        
        
        return alist;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}

//{ Driver Code Starts.

class Driverclass {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        while (n != 0) {
            String input = sc.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans = new Solution().sortByFreq(arr);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();
            n--;
        }
    }
}

// } Driver Code Ends