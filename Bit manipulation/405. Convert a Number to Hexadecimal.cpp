class Solution
{
public:
    string toHex(int num)
    {
        if (num == 0)
        {
            return "0";
        }
        unsigned int num1 = num; // take care of negative integers automatically
        string res = "";
        int base = 16;
        int rem;
        while (num1 > 0)
        {
            rem = num1 % base;
            if (rem < 10)
            {
                res += ('0' + (rem));
            }
            else
            {
                res += ('a' + (rem % 10));
            }
            num1 = num1 / base;
        }
        reverse(res.begin(), res.end());
        return res;
    }
};