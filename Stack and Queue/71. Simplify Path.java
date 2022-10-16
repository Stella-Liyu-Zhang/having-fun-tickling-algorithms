
class Solution {
    public String simplifyPath(String path) {
        /**
         * /.. : come out from the directory
         * /nameOfDirectory : going into directory
         * Time Complexity :- O(N)
         * Space Complexity :- O(N)
         **/
        Stack<String> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for (String c : path.split("/")) {
            if (stack.isEmpty() == false && c.equals("..")) {
                // previous directory, popping off
                stack.pop();
            } else if (!c.equals("") && !c.equals(".") && !c.equals("..")) { // here, no one cares if the stack is empty
                                                                             // or not, we just need to push something
                                                                             // on to it.
                stack.push(c);
            }
        }
        if (stack.isEmpty())
            return "/";
        while (stack.isEmpty() == false) {
            ans.insert(0, stack.pop());
            ans.insert(0, "/");
        }
        return ans.toString();
    }
}