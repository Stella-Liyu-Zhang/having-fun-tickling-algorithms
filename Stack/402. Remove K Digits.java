class Solution {
    /*
    Greedy algo
    make the best possible decision at each step, keep or delete

imply scan from left to right, and remove the first "peak" digit; the peak digit is larger than its right neighbor. One can repeat this procedure k times, and obtain the first algorithm: 
    */
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if (k == len){
            return "0"; 
        }
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < len){
            //whenever meeting a digit which is less than the previous digit, discard the previous one
            //stack.peek() is the previous one, 
            //num.charAt(i) < stack.peek(): we wanna see if the cur one is smaller than prev
            while ( k > 0 && !stack.isEmpty() && num.charAt(i) < stack.peek()){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
            i++;
        }

        //corner case like "1111"
        while (k > 0){
            stack.pop();
            k --;
        }
        //construct the number from stack
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();

        //remove all the 0s at the head
        while (sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}