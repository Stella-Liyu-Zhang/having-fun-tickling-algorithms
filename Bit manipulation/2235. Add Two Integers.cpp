class Solution
{
public:
    /*
    num1 -> sum
    num2 -> carry
    XOR  1 ^ 1 = 0
    0 ^ 0 = 0
    1 ^ 0 = 1
    -> equivalent to the adding without carry

    AND 1 ^ 1 -> 1 -> calculate the carry
    << 1 ->

    num2 == 0 -> carry = 0;
    return num 1, since num1 is the sum.
    */
    int sum(int num1, int num2)
    {
        int sum = num1;
        while (num2 != 0)
        {
            sum = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = sum;
        }
        return sum;
    }
};