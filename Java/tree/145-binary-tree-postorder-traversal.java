/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-postorder-traversal/description/
 *
 * algorithms
 * Easy (78.07%)
 * Likes:    7889
 * Dislikes: 228
 * Total Accepted:    2.1M
 * Total Submissions: 2.7M
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given the root of a binary tree, return the postorder traversal of its
 * nodes' values.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,null,2,3]
 * 
 * Output: [3,2,1]
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
 * Output: [4,6,7,5,2,9,8,3,1]
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
 * The number of the nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 * 
 * 
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;



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
     * Logic: Left -> Right -> Root 
     * - We traverse in reverse order: Root -> Right -> Left using Stack (LIFO): 
     *      1. Pop the current node and prepend its value to the result list via result.addFirst(). 
     *          ex: 1, null, 2, 3 ==> result[1] ==> result[2,1] ==> result[3,2,1]
     *      2. Push the LEFT child into the stack first, the the RIGHT child. 
     *          Due to LIFO, the RIGHT child is popped and processed before the LEFT child.
     * - Prepending values produces the extract Postorder sequence (Left -> Right -> Root).
     * Time complexity: O(n) - Every node is visited exactly once.
     * Space complexity: O(h) - Where h is the height of the tree (O(logn) for balanced trees)
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
         if (root==null) {
            return result;
         }

         Deque<TreeNode> stack = new ArrayDeque<>();
         stack.push(root);

         while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.addFirst(node.val);

            if(node.left!=null){
                stack.push(node.left);
            }
            if(node.right!=null){
                stack.push(node.right);
            }
         }
         return result;
    }
}
// @lc code=end

