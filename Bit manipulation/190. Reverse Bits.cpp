class Solution
{
public:
    /*
    Solution 1:  Bit by bit reverse
    Iterate from right to left, retrive the right-most bit by anding with & 1
    For each bit, we reverse it to the correct position (i.e. (n & 1) << power). Then we accumulate this reversed bit to the final result.
    when n == 0, there is no more bits of one left, stop the iteration

    uint32_t reverseBits(uint32_t n) {
        uint32_t ans = 0;
        int power = 31;

        while(n != 0){
            ans += (n & 1) << power;
            n  = n >> 1;
            power -= 1;

        }
        return ans;
    }
    Solution 1.5:
    uint32_t ReverseBits(uint32_t n)
    {
        uint32_t res;
        for(int i = 0; i < 32; i ++){
            res = res << 1;
            //OR copies the rightmost bit of N to the corresponding position at res.
            res = res | (n & 1);
            n = n >> 1;
        }
        return res;
    }

    Solution 2: divide and conquer


    */
    uint32_t reverseBits(uint32_t n)
    {
        n = (n >> 16) | (n << 16); // This line swaps the leftmost 16 bits with the rightmost 16 bits.
        n = ((n & 0xff00ff00) >> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >> 1) | ((n & 0x55555555) << 1);
        return n;
    }
};