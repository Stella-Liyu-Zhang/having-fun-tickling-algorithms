class Solution {
    /*
    Time complexity: O(n)
    Space complexity: O(n)
    StringBuilder.toString() method is O(n)O(n)O(n

    */
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack();
        Set<Integer> toGetridof = new HashSet();
        for(int i = 0; i < s.length(); i ++){
            if (s.charAt(i) == '('){
                stack.push(i);
            }else if (s.charAt(i) == ')'){
                if(stack.isEmpty()){
                    toGetridof.add(i);
                }else{
                    stack.pop();
                }
            }
        }
        while(stack.isEmpty() == false){
            toGetridof.add(stack.pop());
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < s.length(); i ++){
            if(toGetridof.contains(i) == false){
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}

class Solution2 {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                stack.push(i);
            }else if (s.charAt(i) == ')'){
                if (stack.isEmpty() == false){
                    stack.pop();
                }else{
                    sb.setCharAt(i, '*');
                }
            }
        }
        while(stack.isEmpty() == false){
            sb.setCharAt(stack.pop(), '*');
        }
        return sb.toString().replaceAll("\\*", "");
    }
}