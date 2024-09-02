//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    static class Cell {
        int x;
        int y;
        int distance;

        Cell(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    static class distanceComparator implements Comparator<Cell> {
        public int compare(Cell a, Cell b) {
            if (a.distance < b.distance) {
                return -1;
            } else if (a.distance > b.distance) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    static boolean isInsideGrid(int i, int j, int ROW, int COL) {
        return (i >= 0 && i < ROW && j >= 0 && j < COL);
    }

    public int minimumCostPath(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[][] dp = new int[row][col];

        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                dp[i][j] = Integer.MAX_VALUE;

        dp[0][0] = grid[0][0];

        PriorityQueue<Cell> pq = new PriorityQueue<Cell>(row * col, new distanceComparator());

        pq.add(new Cell(0, 0, dp[0][0]));
        while (!pq.isEmpty()) {
            Cell curr = pq.poll();

            for (int i = 0; i < 4; i++) {
                int rows = curr.x + dx[i];
                int cols = curr.y + dy[i];

                if (isInsideGrid(rows, cols, grid.length, grid[0].length)) {
                    if (dp[rows][cols] > dp[curr.x][curr.y] + grid[rows][cols]) {
                        if (dp[rows][cols] != Integer.MAX_VALUE) {
                            Cell adj = new Cell(rows, cols, dp[rows][cols]);
                            pq.remove(adj);
                        }

                        dp[rows][cols] = dp[curr.x][curr.y] + grid[rows][cols];
                        pq.add(new Cell(rows, cols, dp[rows][cols]));
                    }
                }
            }
        }
        return dp[row - 1][col - 1];
    }
}
