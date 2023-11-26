class Solution {
public:
    /*
    a+b where  a > b
    a-b where a > b

    mask = 0xFFFFFFFF: This is a 32-bit mask with all bits set to 1. 
    It is used to ensure that only the lower 32 bits are considered during bitwise operations.

    a < INT_MAX: This condition checks whether the result a is less than INT_MAX. 
    If this is true, it means there is no overflow, and the function can safely return a as the sum of the two integers.
    a ^ mask: XORing a with the mask inverts all the bits of a. This is equivalent to finding the one's complement of a.

    ~(a ^ mask): The tilde (~) operator then further inverts all the bits of the one's complement, effectively obtaining the two's complement of a. This is a standard technique to represent negative numbers in binary.
    */
    int getSum(int a, int b) {
        long mask = 0xFFFFFFFF;
        while(b != 0){
            int carry = ((a & b) & mask) << 1;
            int ans = (a ^ b) & mask;
            a = ans;
            b = carry;
        }
        return a < INT_MAX ? a : ~(a ^ mask);
    }
};