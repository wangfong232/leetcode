/*
 * @lc app=leetcode id=136 lang=java
 *
 * [136] Single Number
 *
 * https://leetcode.com/problems/single-number/description/
 *
 * algorithms
 * Easy (77.64%)
 * Likes:    19094
 * Dislikes: 915
 * Total Accepted:    4.9M
 * Total Submissions: 6.2M
 * Testcase Example:  '[2,2,1]'
 *
 * Given a non-empty array of integers nums, every element appears twice except
 * for one. Find that single one.
 * 
 * You must implement a solution with a linear runtime complexity and use only
 * constant extra space.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [2,2,1]
 * 
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [4,1,2,1,2]
 * 
 * Output: 4
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [1]
 * 
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 3 * 10^4
 * -3 * 10^4 <= nums[i] <= 3 * 10^4
 * Each element in the array appears twice except for one element which appears
 * only once.
 * 
 * 
 */

// @lc code=start

class Solution {
    /**
     * Problem: 136. Single Number
     * Difficulty: Easy
     * Language: Java
     * * Logic: XOR (Bitwise Manipulation)
     * - Tính chất XOR: a ^ a = 0 và a ^ 0 = a 
     * - Tính chất giao hoán/kết hợp: Các cặp số giống nhau tự triệt tiêu về 0
     *   chỉ còn lại duy nhất số xuất hiện 1 lần. 
     * 
     * * Complexity:
     * - Time: O(n) - duyệt qua mảng đúng 1 lần 
     * - Space: O(1) - Chỉ cần một biến lưu kết quả 
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num; 
        }
        return result;
    }

    /**
     * Problem: 136. Single Number
     * Difficulty: Easy
     * Language: Java
     * * Logic:
     * Vì đầu bài chắc chắn 2 số lặp lại, 1 số lẻ.
     * Nên dùng Set để lưu số chỉ xuất hiện 1 lần
     * Nếu 2 lần thì remove khởi Set.
     * Sau đó lấy số cuối cùng còn trong set.
     * * Complexity:
     * - Time: O(n)
     * - Space: O(n)
     */

    // public int singleNumber(int[] nums) {
    // if(nums.length==1) return nums[0];
    // Set<Integer> set = new HashSet<>();
    // for (int num : nums) {
    // if(set.contains(num)){
    // set.remove(num);
    // }else{
    // set.add(num);
    // }
    // }
    // return set.iterator().next();
    // }
}
// @lc code=end
