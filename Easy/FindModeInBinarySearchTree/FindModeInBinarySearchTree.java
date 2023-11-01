/*
Given the root of a binary search tree (BST) with duplicates, 
return all the mode(s) (i.e., the most frequently occurred element) in it.

If the tree has more than one mode, return them in any order.
Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.

*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class FindModeInBinarySearchTree {
    public int[] findMode(TreeNode root) {
        ResultWrapper resultWrapper = new ResultWrapper();
        inorder(root, resultWrapper);
        return resultWrapper.result.stream().mapToInt(Integer::intValue).toArray();
    }

    private void inorder(TreeNode node, ResultWrapper resultWrapper) {
        if (node == null) {
            return;
        }
        inorder(node.left, resultWrapper);
        int val = node.val;
        resultWrapper.recordStreak(val);
        resultWrapper.updateResult(val);
        inorder(node.right, resultWrapper);
    }

    private static class ResultWrapper {
        private int maxStreak;
        private int currStreak;
        private Integer curr;
        private List<Integer> result;

        public ResultWrapper() {
            this.maxStreak = 0;
            this.currStreak = 0;
            this.curr = 0;
            this.result = new ArrayList<>();
        }

        public void recordStreak(int num) {
            if (num == curr) {
                currStreak++;
            } else {
                currStreak = 1;
                curr = num;
            }
        }

        public void updateResult(int num) {
            if (currStreak > maxStreak) {
                result.clear();
                maxStreak = currStreak;
            }
            if (currStreak == maxStreak) {
                result.add(num);
            }
        }
    }
}