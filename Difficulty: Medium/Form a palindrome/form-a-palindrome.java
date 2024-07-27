//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.countMin(str));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int countMin(String S)
    {
        int n = S.length();
        char[] str = S.toCharArray();
    
        int table[][] = new int[n][n];
        int l, h, gap;

        
        for (gap = 1; gap < n; ++gap)
        for (l = 0, h = gap; h < n; ++l, ++h)
            table[l][h] = (str[l] == str[h])?
                           table[l+1][h-1] :
                          (Integer.min(table[l][h-1],
                                 table[l+1][h]) + 1);

        
        
        return table[0][n-1];
    }
}