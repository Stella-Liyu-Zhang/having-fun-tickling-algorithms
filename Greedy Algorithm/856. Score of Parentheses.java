class Solution {
    /*
    Time: O(n), n is the size of string
    Space: O(n), size of stack ((()))
    When we see a closing bracket, we add twice the score of the previous deeper part - except when counting (), which has a score of 1.
    */
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int i = 0; i < s.length(); i ++){
            if (s.charAt(i) == '('){
                stack.push(0);
            }else if (s.charAt(i) == ')'){
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second + Math.max(2*first , 1));
            }
        }

        return stack.pop();
    }
}