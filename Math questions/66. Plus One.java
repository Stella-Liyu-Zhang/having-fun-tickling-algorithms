class Solution {
    public int[] plusOne(int[] digits) {
        int sum = 0;
        
        for(int i = digits.length - 1; i >= 0; i --){
            if(digits[i] == 9){
                digits[i] = 0;
            }else{
                digits[i] ++;
                return digits;
            }
        }
        //all the digits are nine, so we will extend the array length by 1. And the 
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}