class Solution
{
public:
    /*
    1. Check the ith bit of a number using a bit mask.
    mask = 1, 000001
    Since 0 & 1 = 0, 1&1 = 1
     ->
    shift mask << 1

    Since n is in 32 bit integer, time is O(1)
    Space is O(1)

    int hammingWeight(uint32_t n) {
        int mask = 1;
        int count = 0;
        for(int i = 0; i < 32; i++){
            if((n & mask) != 0){
                count ++;
            }
            mask = mask << 1;
        }
        return count;
    }

    2. Bit manipulation
    we repeatedly flip the least-significant 111-bit of the number to 000, and add 111 to the sum.
    when the number becomes 0 -> no more 1-bitsm return the sum
    Doing a AND of (n)&(n-1) would flip the least significant 1-bit in n to 0.

    */
    int hammingWeight(uint32_t n)
    {
        int count = 0;
        while (n != 0)
        {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
};