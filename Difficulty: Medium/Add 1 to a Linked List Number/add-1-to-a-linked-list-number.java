//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        }
    }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    
    //logic for the reverse.
    public Node reverse(Node head)
    {
        Node prev = null;
        Node curr = head;
        while(curr != null)
        {
            Node next  = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
    public Node addOne1(Node head)
    {
        Node temp = head;
        while(temp != null)
        {
            if(temp.data < 9) 
            {
                temp.data+=1;
                return reverse(head);
            }
            else
            {
                temp.data = 0;
            }
            
            temp = temp.next;
        }
        
        Node n = new Node(1);
        n.next = head;
        return n;
    }
    public Node addOne(Node head) {
        
        if(head == null) return null;
        
        Node headPointer = reverse(head);
        
        // while(headPointer!= null)
        // {
        //     System.out.print(headPointer.data + " ");
        //     headPointer = headPointer.next;
        // }
        
        return addOne1(headPointer);
        
        
    }
}
