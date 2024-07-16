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
            List<Integer> arr = new ArrayList<>();
            String input = sc.nextLine();
            Scanner ss = new Scanner(input);
            while (ss.hasNextInt()) {
                arr.add(ss.nextInt());
            }
            Solution ob = new Solution();
            int ans = ob.print2largest(arr);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int print2largest(List<Integer> arr) {
        
        int fm = -1;
        int sm = -1;
        
        for(int i=0; i<arr.size(); i++)
        {
            int cur = arr.get(i);
            if(cur > fm)
            {
                sm = fm;
                fm = cur;
            }
            else if(cur < fm && cur > sm)
            {
                sm = cur;
            }
        }
        
        return sm;
    }
}