class Solution {
    /*
     * 1+(4+5+2)-3)+(6+8)
     * sum : 1+ 4 +5+2 = 12
     * stack: 1, +,
     * go through the string character by character
     * use stack to save previous result when we see open paratathese
     * if we reach close ), wrap the result in stack
     * pop it, from stack
     * 
     * time: O(m), went through each character only once
     */
    public int calculate(String s) {
        int sign = 1;
        int sum = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            // number
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                // 9 or 999
                int num = 0;
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                sum += num * sign;
                i--;
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                stack.push(sum);
                stack.push(sign);
                sum = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                sum = stack.pop() * sum;
                sum += stack.pop();
            }
        }
        return sum;
    }
}