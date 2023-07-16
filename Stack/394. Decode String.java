class Solution {
    public String decodeString(String s) {
        //stack, first in last out, last in first out
        //four different types of characters 
        //2 stacks to track the digits and letters respectively
        /*
        An open bracket means the start of a string to encode, while we come across a closed bracket, it means that we already  
        */
        //intuition to use stack
        //last data: most nested character must be evaluated first, which matches stack's algo.
        Stack<Integer> countStack = new Stack<>();
        Stack<String> wordStack = new Stack<>();
        int number = 0;
        
        StringBuilder word = new StringBuilder();
                
        for(int i = 0; i < s.length(); i ++){
            char curr = s.charAt(i);
            if (Character.isDigit(curr)){
                //character to integer, vertified curr is a digit, substract character to each other, we get an integer value
                //'1'(49) - '0'(48) = 1
                //number*10
                //builder the number, account for the place we are at. 
                //153: (1*10+5)*10+3 = 153
                number = number*10 + (curr - '0');
            }else if (Character.isLetter(curr)){
                word.append(curr);
            }else if (curr == '['){
                //add both the number and word to our stack
                countStack.add(number);
                wordStack.add(word.toString());
                number = 0;
                word = new StringBuilder();
            }else{
                int count = countStack.pop();
                StringBuilder duplicatedWord = new StringBuilder(wordStack.pop());
                for(int j = 1; j <= count; j ++){
                    duplicatedWord.append(word);
                }
                word = duplicatedWord;
            }
        }
        return word.toString();

        
    }
}

/*
Time: O(M*N)
Space: O(M+N)
*/