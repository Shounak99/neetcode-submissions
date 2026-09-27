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
class Solution {
    Map<TreeNode,Integer> dp=new HashMap<>();
    public int rob(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(dp.containsKey(root)){
            return dp.get(root);
        }
        int left=0;
        int right=0;
        if(root.left!=null){
            left=rob(root.left.left)+rob(root.left.right);
        }

        if(root.right!=null){
            right=rob(root.right.left)+rob(root.right.right);
        }
        dp.put(root,Math.max(root.val+left+right,rob(root.left)+rob(root.right)));
        return dp.get(root);
    }
}