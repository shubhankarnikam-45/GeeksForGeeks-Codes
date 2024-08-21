//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Pair
{
    int vertex;
    int wt;
    
    Pair(int vertex, int wt)
    {
        this.vertex = vertex;
        this.wt = wt;
    }
}
class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        
        //first created the adjacency list.
        ArrayList<ArrayList<Integer>> alist = new ArrayList<>();
        
        //allocate memory
        for(int i = 0 ;i<n ;i++)
        {
            alist.add(new ArrayList<Integer>());
        }
        
        for(int i=0; i<m ;i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            
            alist.get(u).add(v);
            alist.get(v).add(u);
        }
        
        
        //created the visited array.
        int visited[] = new int[n];
        
        Arrays.fill(visited, -1);
        
        //created the queue.
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(src, 0));
        
        while(queue.size() > 0)
        {
            //remove.
            Pair p = queue.remove();
            int vertex = p.vertex;
            int weight = p.wt;
            
            if(visited[vertex] == -1)
            {
                visited[vertex] = weight;
            }
            
            //going to neighbour.
            for(int nbr : alist.get(vertex))
            {
                if(visited[nbr] == -1)
                queue.add(new Pair(nbr, weight + 1));
            }
            
            
        }
        
        return visited;
        
    }
}