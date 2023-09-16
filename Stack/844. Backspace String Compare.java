class Solution {
    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }
    public String build(String s){
        Stack<Character> stack = new Stack();
        for(char c: s.toCharArray()){
            if(c != '#'){
                stack.push(c);
            }else if (stack.isEmpty() == false){
                stack.pop();
            }
        }
        return String.valueOf(stack);
    }
}