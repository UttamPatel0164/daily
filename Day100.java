public Maximum Non-Adjacent Nodes Sum
Difficulty: MediumAccuracy: 55.35%Submissions: 94K+Points: 4Average Time: 45m
Given the root of a binary tree with integer values. Your task is to select a subset of nodes such that the sum of their values is maximized, with the condition that no two selected nodes are directly connected that is, if a node is included in the subset, neither its parent nor its children can be included.

Examples:/*
class Node {
    int data;
    Node left, right;

    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
*/

class Nd {
    Node node;
    int prev;
    Nd(Node node, int prev) {
        this.node = node;
        this.prev = prev;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nd other = (Nd) o;
        return prev == other.prev && node == other.node;
    }

    @Override
    public int hashCode() {
        return Objects.hash(node, prev);
    }
}

class Solution {
    public int fun(Node root, int prev, Map<Nd, Integer> dp) {
        if (root == null)
            return 0;

        Nd key = new Nd(root, prev);
        if (dp.containsKey(key))
            return dp.get(key);

        int res;
        if (prev == 1) {
            res = fun(root.left, 0, dp) + fun(root.right, 0, dp);
        } else {
            int take = root.data + fun(root.left, 1, dp) + fun(root.right, 1, dp);
            int notTake = fun(root.left, 0, dp) + fun(root.right, 0, dp);
            res = Math.max(take, notTake);
        }

        dp.put(key, res);
        return res;
    }

    public int getMaxSum(Node root) {
        Map<Nd, Integer> dp = new HashMap<>();
        return Math.max(fun(root, 0, dp), fun(root, 1, dp));
    }
}
 Day100 {
    
}
