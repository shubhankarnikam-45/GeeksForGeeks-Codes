//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String ss = br.readLine();
            String[] S = ss.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            List<String> ans = new ArrayList<String>();
            ans = ob.all_longest_common_subsequences(s, t);
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i) + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    
    public List<String> fun(int index1, int index2, String s, String t, List<String>[][] dp) {
        // Base case.
        if(index1 < 0 || index2 < 0) {
            List<String> alist = new ArrayList<>();
            alist.add("");
            return alist;
        }
        
        if(dp[index1][index2].size() != 0) return dp[index1][index2];
        
        // If characters at both indices match.
        if(s.charAt(index1) == t.charAt(index2)) {
            List<String> alist1 = fun(index1 - 1, index2 - 1, s, t, dp);
            List<String> newList = new ArrayList<>();
            for (String str : alist1) {
                newList.add(str + s.charAt(index1)); // append character
            }
            dp[index1][index2] = newList;
            return newList;
        }
        
        // Calculate the two possibilities: ignoring one character from each string.
        List<String> alist2 = fun(index1 - 1, index2, s, t, dp);
        List<String> alist3 = fun(index1, index2 - 1, s, t, dp);
        
        // Merge the lists based on their lengths.
        if(alist2.get(0).length() > alist3.get(0).length()) {
            dp[index1][index2] = alist2;
            return alist2;
        } else if(alist3.get(0).length() > alist2.get(0).length()) {
            dp[index1][index2] = alist3;
            return alist3;
        } else {
            Set<String> mergedSet = new HashSet<>(alist2);
            mergedSet.addAll(alist3);
            List<String> mergedList = new ArrayList<>(mergedSet);
            dp[index1][index2] = mergedList;
            return mergedList;
        }
    }
    
    public List<String> all_longest_common_subsequences(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        List<String>[][] dp = new ArrayList[m][n];
        // Initialize the ArrayLists at each position in the 2D array
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new ArrayList<>();
            }
        }
        
        List<String> ans = fun(m - 1, n - 1, s, t, dp);
        
        // Use a Set to remove duplicates
        Set<String> set = new HashSet<>(ans);
        ans = new ArrayList<>(set);
        Collections.sort(ans);
        
        return ans;
    }
}
