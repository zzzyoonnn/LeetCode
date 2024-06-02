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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        // tree가 비어있으면 false 반환
        if (root == null) {
            return false;
        }
        
        // 리프노드라면(자식 노드가 없다면)
        if (root.left == null && root.right == null) {
            
            // 현재 노드의 값이 targetSum과 같은지 확인
            return targetSum == root.val;
        }
        
        // 리프노드가 아니라면, 왼쪽과 오른쪽 자식 노드로 재귀 호출
        boolean leftSum = hasPathSum(root.left, targetSum - root.val);
        boolean rightSum = hasPathSum(root.right, targetSum - root.val);
        
        // 두 재귀 호출 중 하나라도 true라면 true 반환
        return leftSum || rightSum;
    }
}