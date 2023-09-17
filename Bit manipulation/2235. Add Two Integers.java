class Solution {
    /*
    Let's add 3 (binary 0011) and 5 (binary 0101):

    num1 ^ num2 gives us 0010, which represents the XOR result (sum without carry).
    (num1 & num2) << 1 gives us 0001 (carry, shifted by 1 position to the left).
    The recursive call now adds 0010 (sum without carry) and 0001 (carry), which gives us 0011, representing the final sum (binary 6).
    */
    public int sum(int num1, int num2) {
        if(num2 == 0){
            return num1;
        }
        return sum(num1 ^ num2, (num1 & num2) << 1);
    }
}