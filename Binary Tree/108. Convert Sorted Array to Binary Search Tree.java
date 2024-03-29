/*
ime complexity: O(N) since we visit each node exactly once.

Space complexity: O(log⁡N)
*/
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0){
            return null;
        }
        TreeNode head = helper(nums, 0, nums.length - 1);
        return head;
    }

    public TreeNode helper (int[] num, int low, int high){
        if (low > high){ // Done
            return null;
        }
        int mid = (low+high)/2;
        TreeNode node = new TreeNode (num[mid]);
        node.left = helper (num, low, mid-1);
        node.right = helper(num, mid+1, high);
        return node;
    }
}