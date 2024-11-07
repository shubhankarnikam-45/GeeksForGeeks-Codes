//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());

        while (testCases-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            Solution ob = new Solution();
            List<Integer> result = ob.findSplit(arr);

            if (result.get(0) == -1 && result.get(1) == -1 || result.size() != 2) {
                System.out.println("false");
            } else {
                int sum1 = 0, sum2 = 0, sum3 = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (i <= result.get(0))
                        sum1 += arr[i];

                    else if (i <= result.get(1))
                        sum2 += arr[i];

                    else
                        sum3 += arr[i];
                }
                if (sum1 == sum2 && sum2 == sum3) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {

    public List<Integer> findSplit(int[] arr) {
        
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        
        //length of array.
        int n = arr.length;
        
        for(int i=0; i<n; i++)
        {
            sum1+=arr[i];
            
            for(int j=i+1; j<n; j++)
            {
                sum2+=arr[j];
                if(!(sum1 == sum2)) continue;
                
                for(int k=j+1; k<n; k++)
                {
                    sum3+=arr[k];
                    
                    if(k == n-1 && sum3 == sum2)
                    {
                        List<Integer> ans = new ArrayList<>();
                        ans.add(i);
                        ans.add(j);
                        return ans;
                    }
                    
                    
                }
                sum3 = 0;
                
                
            }
            sum2 = 0;
        }
        
        List<Integer> ans = new ArrayList<>();
        ans.add(-1);
        ans.add(-1); 
        return ans;

    }
}