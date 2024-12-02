//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s, patt;
            s = sc.next();
            patt = sc.next();

            Solution ob = new Solution();

            ArrayList<Integer> res = ob.search(patt, s);
            if (res.size() == 0)
                System.out.print("[]");
            else {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    ArrayList<Integer> search(String pat, String txt) {
        
        //length of pat string.
        int pn = pat.length();
        //length of txt string.
        int tn = txt.length();
        
        //arraylist that retuns the answer.
        ArrayList<Integer> alist = new ArrayList<>();
        
        //traverse string txt and find the required answer.
        for(int i=0; i<= tn - pn; i++)
        {
            //current character of txt string.
            char ch = txt.charAt(i);
            
            //if first character pat and 'ch' matches then we check for pattern
            //present in the txt or not.
            if(ch == pat.charAt(0))
            {
                if(pat.equals(txt.substring(i, i + pn)))
                {
                    alist.add(i);
                }
            }
        }
        
        //return the answer.
        return alist;
    }
}