//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the remaining newline

        for (int k = 0; k < t; k++) {
            List<Integer> arr1 = new ArrayList<>();
            String input = sc.nextLine();
            Scanner lineScanner = new Scanner(input);
            while (lineScanner.hasNextInt()) {
                arr1.add(lineScanner.nextInt());
            }
            lineScanner.close();

            List<Integer> arr2 = new ArrayList<>();
            input = sc.nextLine();
            lineScanner = new Scanner(input);
            while (lineScanner.hasNextInt()) {
                arr2.add(lineScanner.nextInt());
            }
            lineScanner.close();

            Solution ob = new Solution();
            int ans = ob.maxPathSum(arr1, arr2);
            System.out.println(ans);
        }

        sc.close();
    }
}

// } Driver Code Ends



class Solution {
    public int maxPathSum(List<Integer> arr1, List<Integer> arr2) {
        
        //creating hashset.
        HashSet<Integer> hset = new HashSet<>();
        
        //traverse in the second liset.
        for(int i=0; i<arr2.size(); i++)
        {
            hset.add(arr2.get(i));
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        
        //now find the unique element
        for(int i=0; i<arr1.size(); i++)
        {
            if(hset.contains(arr1.get(i)))
            {
                queue.add(arr1.get(i));
            }
        }
        
        
        int i=0;
        int j=0;
        int m = arr1.size();
        int n = arr2.size();
        
        int sum = 0;
        while(i < m && j<n && queue.size() > 0)
        {
            //cur element.
            int cur = queue.remove();
            
            int firstSum = 0;
            int secondSum = 0;
            
            while(arr1.get(i) != cur)
            {
                firstSum +=arr1.get(i);
                i++;
            }
            
            while(arr2.get(j) != cur)
            {
                secondSum += arr2.get(j);
                j++;
            }
            
            i++;
            j++;
            
            sum+= cur + Math.max(firstSum, secondSum);
            
        }
        
        
            int firstSum = 0;
            int secondSum = 0;
            
            while(i < m)
            {
                firstSum +=arr1.get(i);
                i++;
            }
            
            while(j < n)
            {
                secondSum += arr2.get(j);
                j++;
            }
            
            sum+=Math.max(firstSum, secondSum);
        
        
        return sum;
    }
}