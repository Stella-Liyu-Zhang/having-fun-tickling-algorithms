class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(c != '*'){
                stack.push(c);
            }else{
                if(stack.isEmpty() == false){
                    stack.pop();
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        while(stack.isEmpty() == false){
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }
}