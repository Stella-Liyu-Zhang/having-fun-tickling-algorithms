class Solution {
    public String addStrings(String num1, String num2) {
        int ptr1 = num1.length() - 1;
        int ptr2 = num2.length() - 1;

        int carry = 0;
        StringBuilder ans = new StringBuilder();
        while(ptr1 >= 0 || ptr2 >= 0){
            int a = 0, b = 0;
            if(ptr1 >= 0){
                a = num1.charAt(ptr1) - '0';
            }
            if(ptr2 >= 0){
                b = num2.charAt(ptr2) - '0';
            } 
            int value = (a + b + carry) % 10;
            carry = (a + b + carry) / 10;
            ans.append(value);
            ptr1 --;
            ptr2 --;

        }
        if(carry != 0){
            ans.append(carry);
        }
        return ans.reverse().toString();
    }
}