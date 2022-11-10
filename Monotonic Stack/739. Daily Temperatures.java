class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] ans = new int[len];
        // stack store the index of the next biggest element
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (stack.isEmpty() == false && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                ans[index] = i - index;
            }
            stack.push(i);
        }
        return ans;
    }
}