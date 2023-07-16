/*
This is a good problem to apply stack, with the following idea: let us traverse original list number by number and put in into stack: if it happens that new number is less than the top of our stack and if we still can afford to delete one more number, we extract it from stack and put new number. Let me illustrate this on example [1,4,5,3,2,8,7] and k = 4.

First, we put 1 into stack, then 4 and then 5, so far we have [1, 4, 5]. Next step we see number 3, which is less then 5, so we keep removing elements from stack until we can and put 3, so we have [1, 3] now. Next number is 2, so we again remove 3 and put 2, and we have [1, 2] in our stack now. At this moment number of attempts we can make is equal to zero, so we just must take all the rest numbers, so finally we have [1, 2, 8, 7] in our stack.

*/

class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[k];
        for (int i = 0; i < nums.length; i++) {
            // new number is less than the top of our stack and we still can afford to
            // delete one more number
            while (!stack.isEmpty() && nums[i] < stack.peek() && nums.length - i + stack.size() > k) {
                stack.pop();
            }
            if (stack.size() < k) {
                stack.push(nums[i]);
            }
        }
        int i = k - 1;
        while (stack.isEmpty() == false && i >= 0) {
            ans[i] = stack.pop();
            i--;
        }
        return ans;
    }
}