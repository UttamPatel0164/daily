import org.w3c.dom.Node;

public /*
class Node {
    int data;
    Node left, right;
    Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    int ans;

    private int fun(Node node) {
        if (node == null)
            return 0;

        int left = Math.max(fun(node.left), 0);
        int right = Math.max(fun(node.right), 0);

        ans = Math.max(ans, node.data + left + right);

        return node.data + Math.max(left, right);
    }

    int findMaxSum(Node root) {
        ans = Integer.MIN_VALUE;
        fun(root);
        return ans;
    }
}
 {
    
}
