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

//second attempt
class Solution {
    /*
    stack
    array
    path "/" as delimiter
    stringbuilder
    . pop()

    */
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> stack = new Stack();
        for(int i = 0; i < arr.length; i ++){
            if(arr[i].equals(".") || arr[i].isEmpty()){ //use isEmpty() to check the empty string
                continue;
            }else if (arr[i].equals("..")){
                if(stack.isEmpty() == false){
                    stack.pop();
                }
            }else{ // /a/b/
                stack.push(arr[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String s: stack){
            sb.append('/');
            sb.append(s);
        }
        return sb.length() > 0 ? sb.toString() : "/";

    }
}