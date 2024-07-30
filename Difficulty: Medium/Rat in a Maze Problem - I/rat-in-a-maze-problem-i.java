//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    ArrayList<String> alist = new ArrayList<>();
    public void findPathHelper(int mat[][], int lenOfRows, int lenOfCols, String ans, boolean track[][], int i, int j)
    {
        
        //base case.
        if(lenOfRows == i || lenOfCols == j || i < 0 || j < 0  || track[i][j] == true || mat[i][j] == 0)
        {
            return;
        }
        
        //calculate the anser.
        if(i == lenOfRows-1 && j == lenOfCols-1)
        {
            //added to arraylist.
            alist.add(ans);
            return;
        }
        
        //mark.
        track[i][j] = true;
        
        
        findPathHelper(mat, lenOfRows, lenOfCols, ans+"U", track, i-1, j);
        findPathHelper(mat, lenOfRows, lenOfCols, ans+"D", track, i+1, j);
        findPathHelper(mat, lenOfRows, lenOfCols, ans+"L", track, i, j-1);
        findPathHelper(mat, lenOfRows, lenOfCols, ans+"R", track, i, j+1);
        
        //backtracking.
        track[i][j] = false;
    }
    public ArrayList<String> findPath(int[][] mat) {
        
        String ans = "";
        int i = 0;
        int j = 0;
        
        //for traacking create array.
        int lenOfRows = mat.length;
        int lenOfCols = mat[0].length;
        boolean track[][] = new boolean [lenOfRows][lenOfCols];
        
        findPathHelper(mat, lenOfRows, lenOfCols, ans, track, i, j);
        return alist;
    }
}