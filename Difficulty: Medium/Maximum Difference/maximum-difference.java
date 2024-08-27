//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.findMaxDiff(arr));
        }
    }
}

// } Driver Code Ends



class Solution {
    public int findMaxDiff(int[] arr) {
        Stack<Integer> stack1 = new Stack<>();

        int leftSmall[] = new int[arr.length];
        int rightSmall[] = new int[arr.length];

        // Finding nearest left smaller elements
        leftSmall[0] = 0;
        stack1.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int currElement = arr[i];

            while (stack1.size() > 0 && stack1.peek() >= currElement) {
                stack1.pop();
            }

            if (stack1.size() == 0) leftSmall[i] = 0;
            else leftSmall[i] = stack1.peek();

            stack1.push(currElement);
        }

        // Finding nearest right smaller elements
        stack1.clear(); // clear the stack to reuse it for right smaller elements

        for (int i = arr.length - 1; i >= 0; i--) {
            int currElement = arr[i];

            while (stack1.size() > 0 && stack1.peek() >= currElement) {
                stack1.pop();
            }

            if (stack1.size() == 0) rightSmall[i] = 0;
            else rightSmall[i] = stack1.peek();

            stack1.push(currElement);
        }

        // Finding maximum difference
        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int diff = Math.abs(leftSmall[i] - rightSmall[i]);
            if (diff > maxi) maxi = diff;
        }

        return maxi;
    }
}
