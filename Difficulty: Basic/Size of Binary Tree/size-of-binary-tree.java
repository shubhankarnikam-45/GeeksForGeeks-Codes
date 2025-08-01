/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public static int getSize(Node node) {
        
        //base case.
        if(node == null) return 0;
      
        return getSize(node.left) + getSize(node.right) + 1;
        
    }
}