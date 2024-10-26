//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    static FastReader sc=new FastReader(System.in);
    public static void main(String args[]) throws IOException{
       
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            String []arr=new String[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.next();
            }
            Solution obj=new Solution();
            int res=obj.longestChain(N, arr);
            System.out.println(res);
        
System.out.println("~");
}
    }
   static class FastReader{
 
        byte[] buf = new byte[2048];
        int index, total;
        InputStream in;
 
        FastReader(InputStream is) {
            in = is;
        }
 
        int scan() throws IOException {
            if (index >= total) {
                index = 0;
                total = in.read(buf);
                if (total <= 0) {
                    return -1;
                }
            }
            return buf[index++];
        }
 
        String next() throws IOException {
            int c;
            for (c = scan(); c <= 32; c = scan());
            StringBuilder sb = new StringBuilder();
            for (; c > 32; c = scan()) {
                sb.append((char) c);
            }
            return sb.toString();
        }
 
        int nextInt() throws IOException {
            int c, val = 0;
            for (c = scan(); c <= 32; c = scan());
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }
 
        long nextLong() throws IOException {
            int c;
            long val = 0;
            for (c = scan(); c <= 32; c = scan());
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }
    }
   
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public boolean checkPossible(String s1, String s2)
    {
        //here s1 is bigger and 
        //     s2 is smaller.
        if(s1.length() != s2.length() + 1) return false;
        
        int i = 0;  //points to the string s1
        int j = 0;  //points to the sring s2
        
        while(i < s1.length())
        {
            if(j < s2.length() && s1.charAt(i) == s2.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
                i++;
            }
        }
        
        if(i == s1.length() && j == s2.length()) return true;
        return false;
    }
    public int longestChain(int N, String words[]){
        
        //sort the words array using lambda expression.
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        
        //creating dp[] array that stores the length.
        int dp[] = new int[N];
        
        //that return the final max value.
        int maxi = 1;
        
        for(int i=0; i<N; i++)
        {
            dp[i] = 1;
            for(int prev = 0; prev < i; prev++)
            {
                if(checkPossible(words[i], words[prev]) && dp[i] < dp[prev] + 1)
                {
                    dp[i] = dp[prev] + 1;
                }
            }
            
            if(maxi < dp[i]) maxi = dp[i];
        }
        
        //return the final answer.
        return maxi;
        
    }
}