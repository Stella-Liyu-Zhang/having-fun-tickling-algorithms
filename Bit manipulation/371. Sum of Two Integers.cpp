class Solution
{
public:
    /*
    1 + 1 -> only carry needed

    1. a ^ b we know gives us sum value WITH ALL DIGITS ADDED without carry: 0 ^ 0 = 0 , 1 ^ 0 = 1, 0 ^ 1 = 1, 1 ^ 1 = 0, this is what the sum of each digit should be without thinking of the carry.

    2. The AND (logical AND) operation results in 1 only if both corresponding bits of the operands are 1. If either or both bits are 0, the AND result is 0.

    3. When b == 0, there is no more carries finally!
    */
    int getSum(int a, int b)
    {
        int sum = a;
        int mask = 0xFFFFFFFF;
        while (b != 0)
        {
            sum = (a ^ b) & mask;
            b = ((a & b) & mask) << 1;
            a = sum;
        }
        return sum;
    }
};