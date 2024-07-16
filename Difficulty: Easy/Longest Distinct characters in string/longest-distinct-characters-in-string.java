//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubstrDistinctChars(String S){
        
        //size.
        int length = S.length();
        
        //relesing.
        int j = 0;
        
        //aquring.
        int i = 0;
        
        int max = Integer.MIN_VALUE;
        
        HashMap<Character, Integer> hmap = new HashMap<>();
        
        while(true)
        {
            //aquire.
            //current character.
            char ch = S.charAt(i);
            
            hmap.put(ch, hmap.getOrDefault(ch, 0)+1);
            
            if(hmap.get(ch) > 1)
            {
                char store = ch;
                
                max = Math.max(max, i-j);
                
                //relesing.
                while(j < S.length() && S.charAt(j)!=store)
                {
                    hmap.remove(S.charAt(j));
                    j++;
                }
                j++;
                
                hmap.put(ch, 1);
            }
            
            i++;
            
            if(i == S.length()) break;
            
        }
        
           max = Math.max(max, i-j);
        
        return max;
        
    }
}