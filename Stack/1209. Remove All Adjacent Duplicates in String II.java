class Solution {
    public String removeDuplicates(String s, int k) {
        /*
         * 
         * Input: s = "deeedbbcccbdaa", k = 3
         * Key-value pairs:
         * Main stack: {e,3} {d,1},
         * pop {e,3} off,
         * 
         * Time: O(N); Space O(N)
         */
        Stack<int[]> main = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!main.isEmpty() && main.peek()[0] == c) {
                main.peek()[1]++;
            } else {
                main.push(new int[] { c, 1 });
            }

            if (main.peek()[1] == k) {
                main.pop();
            }
        }
        StringBuilder ans = new StringBuilder();

        while (!main.isEmpty()) {
            int[] top = main.pop();

            while (top[1]-- > 0)
                ans.append((char) top[0]);
        }

        return ans.reverse().toString();
    }
}

class Solution {
    public String removeDuplicates(String s, int k) {
        // Time: O(N); Space: O(N)
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }
            if (count == k) {
                String reduced = s.substring(0, i - k + 1) + s.substring(i + 1);
                return removeDuplicates(reduced, k);
            }
        }
        return s;
    }
}