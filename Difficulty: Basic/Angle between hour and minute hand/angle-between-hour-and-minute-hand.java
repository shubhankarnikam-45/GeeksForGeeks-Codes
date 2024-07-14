//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int H = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);

            Solution ob = new Solution();
            System.out.println(ob.getAngle(H,M));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static int getAngle(int H , int M) {
        // Calculate the position of the hour hand
        double hourAngle = (H % 12) * 30 + (M / 60.0) * 30;
        
        // Calculate the position of the minute hand
        double minuteAngle = M * 6;
        
        // Calculate the difference between the two angles
        double angle = Math.abs(hourAngle - minuteAngle);
        
        // Find the minimum angle between the two possible angles
        angle = Math.min(angle, 360 - angle);
        
        // Return the floor of the result
        return (int)Math.floor(angle);
    }
}
