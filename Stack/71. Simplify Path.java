class Solution {
    /*
    Time: O(N)

    Space Complexity: O(N)
    Actually, it's 2N because we have the array that contains the split components and then we have the stack.
    */
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack();
        String[] components = path.split("/");

        for(String dir: components){
            if(dir.equals(".") || dir.isEmpty()){
                continue;
            }else if (dir.equals("..")){
                if(stack.isEmpty() == false){
                    stack.pop();
                }
            }else{
                stack.push(dir);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String s: stack){
            sb.append("/");
            sb.append(s);
        }
        return sb.length() > 0 ? sb.toString() : "/";
    }
}