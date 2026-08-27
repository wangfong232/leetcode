/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 *
 * algorithms
 * Easy (75.67%)
 * Likes:    9011
 * Dislikes: 237
 * Total Accepted:    2.6M
 * Total Submissions: 3.4M
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given the root of a binary tree, return the preorder traversal of its nodes'
 * values.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,null,2,3]
 * 
 * Output: [1,2,3]
 * 
 * Explanation:
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
 * 
 * Output: [1,2,4,5,6,7,3,8,9]
 * 
 * Explanation:
 * 
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: root = []
 * 
 * Output: []
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: root = [1]
 * 
 * Output: [1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 * 
 * 
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * 
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


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

    /**
     * Logic: Root -> Left -> Right
     * - Pop the top node from stack and record its value (Root).
     * - Push the RIGHT child into the stack first, then LEFT child.
     *  Due to Stack (LIFO - Last In First Out), the LEFT child pops first and is processed next. 
     * 
     * Time complexity: O(n) - Every node is visited exactly once.
     * Space complexity: O(h) - Where h is the height of the tree (O(logn) for balanced trees)
     */
    public List<Integer> preorderTraversal(TreeNode root) {
         List<Integer> result = new ArrayList<>();
         if (root==null) {
            return result;
         }

         Deque<TreeNode> stack = new ArrayDeque<>();
         stack.push(root);

         while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);

            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
         }
         return result;
    }

    /**
     * Time complexity: O(n) - Every node is visited exactly once.
     * Space complexity: O(h) - Where h is the height of the tree (O(logn) for balanced trees)
     */
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     List<Integer> result = new ArrayList<>();
    //     traverse(root, result);
    //     return result;
    // }

    // private void traverse(TreeNode root, List<Integer> result){
    //     if(root==null) return;
    //     result.add(root.val);
    //     traverse(root.left, result);
    //     traverse(root.right, result);
    // }
}
// @lc code=end

