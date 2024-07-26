//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());
        while (t-- > 0) {
            String str = sc.nextLine();
            int k = Integer.parseInt(sc.nextLine().trim());
            Solution obj = new Solution();
            if (obj.kPangram(str, k))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


class Solution {
    boolean kPangram(String str, int k) {
        // create an array to store the frequency of each letter in the alphabet
        int map[] = new int[26];
        
        Arrays.fill(map, 0);
     
        int total = 0;
        // iterate through the string character by character
        for (int i = 0; i < str.length(); i++) {
            
            if (str.charAt(i) == ' ') continue;
            
            map[(int)str.charAt(i) - (int)'a']++;
            
            total++;
        }
        
        if (total < 26) return false;
      
        int count = 0;
      
        for (int i = 0; i < 26; i++) {
            
            if (map[i] != 0) count++;
        }
      
        if (count + k >= 26) return true;
        // otherwise, return false
        return false;
    }
}