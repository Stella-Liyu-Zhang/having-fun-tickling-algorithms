class Solution {
    /*
    1) white space
    2) sign (+,-)
    3) If we have (word) after numerical value
    4) string does not exists
    5) just sequence is not numeric and non-whitespace
    6) out of range
    */
    public int myAtoi(String s) {
        if(s.length() == 0){
            return 0;
        }
        s = s.trim(); //get rid of leading and trailing white spaces
        int sign = 1;
        int index = 0;
        int total = 0;
        
        //handle the signs
        if(index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-')){
            sign = s.charAt(index) == '+' ? 1:-1;
            index ++;
        }
        while(index < s.length()){
            int digit = s.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;
            //check if the total will be overflow after times 10
            if(total > (Integer.MAX_VALUE - digit)/10){
                return sign == 1? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = 10*total + digit;
            index ++;
        }
        return total*sign;

    }
}