class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();

        char sign = '+';
        int num = 0; 
        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            if (c >= '0' && c <= '9'){ // is a digit
                num = 10*num + c-'0';
            }
            if(!Character.isDigit(c) && c!= ' ' || i == s.length() - 1){ // Not a digit, not empty; Or at the very last digit
                if (sign == '+'){
                    stack.push(num);
                }else if (sign == '-'){
                    stack.push(num*-1);
                }else if (sign == '*'){
                    stack.push(stack.pop()*num);
                }else if (sign == '/'){
                    stack.push(stack.pop()/num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }
        int sum = 0;
        while(stack.isEmpty() == false){
            sum += stack.pop();
        }
        return sum;
    }
}

//second attempt
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        s.replace(" ", "");

        char sign = '+';
        int num = 0;

        for(int i = 0; i < s.length(); i ++){
            char curr = s.charAt(i);
            if (Character.isDigit(curr)){
                num = num*10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(curr) && curr!= ' ' || i == s.length() - 1){ //not a digit, not empty; or at very last digit
                if(sign == '+'){
                    stack.push(num);
                }else if (sign == '-'){
                    stack.push(-num);
                }else if (sign == '/'){
                    stack.push(stack.pop()/num);
                }else if (sign == '*'){
                    stack.push(stack.pop() * num);
                }
                sign = s.charAt(i);
                num = 0;
            }
            
        }
        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }
}