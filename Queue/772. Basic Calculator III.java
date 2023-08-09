class Solution {
    /*
    digit, +, - , * , /, (, )
    () has more priority than +,-, which means we cannot go from left to right
    calculate the innermost () values
    Depth first search
    if we have -, we take it as sign for the next integer

    Step 0: preprocessing, remove whitespace, use queue, poll or offer is both: O(1)
    Step 1: process the string

    while(!q.isEmpty()){
        char c = q.poll();
        if (c is igit){
            num = num*10 + c - '0';
        }else if (c == 'c'){
            num = helper(1);
            recursively all the helper function
        }else{
            switch(prevOperation){
                case '+':
                    sum += prev;
                    prev = num;
                    break;
                case '-':
                    sum += prev;
                    prev = -num;
                    break;
                case '*':
                    prev *= num;
                    break;
                case '/':
                    prev /= num;
                    break;
            }
            if(c == ')'){
                break;
            }
            num = 0;
            prevOp = c;
        }
        return sum + prev;
    }

    Tips:
    1. add one more placeholder in the end
    2. for '+', deplay one step
        '-' , change it to +(-5)
        7 - 5*7
        '*': two parameter
        '/' eagerly calcualte them
    3. for '(' , dfs (rest part)
       for ')', return the num
    */
    public int calculate(String s) {
         Queue<Character> queue = new ArrayDeque<>();
         for(char c: s.toCharArray()){
             if (c != ' '){
                 queue.offer(c);
             }
         }
         queue.offer(' ');
         return helper(queue);
    }

    private int helper(Queue<Character> queue){
        int num = 0, prev = 0, sum = 0;
        char prevOp = '+';

        while(queue.isEmpty() == false){
            char c = queue.poll();
            if (Character.isDigit(c)){
                num = num*10 + c - '0';
            }else if (c == '('){
                num = helper(queue);
            }else{
                switch (prevOp){
                    case '+':
                        sum += prev;
                        prev = num;
                        break;

                    case '-':
                        sum += prev;
                        prev = -num;
                        break;

                    case '*':
                        prev *= num;
                        break;

                    case '/':
                        prev /= num;
                        break;
                }
                if(c == ')'){
                    break;
                }
                prevOp = c; //make the prevOp to become c, since c def be an op here
                num = 0; //set the num back to 0
            }
        }
        return sum + prev;
    }
}