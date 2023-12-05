class Solution
{
public:
    /*
    2 pointers at end of a and b
    add them
    */
    string addBinary(string a, string b)
    {
        int aptr = a.length() - 1;
        int bptr = b.length() - 1;
        int remainder = 0;
        string ans = "";
        while (aptr >= 0 || bptr >= 0 || remainder != 0)
        {
            if (aptr >= 0)
            {
                remainder += a[aptr] - '0';
                aptr--;
            }
            if (bptr >= 0)
            {
                remainder += b[bptr] - '0';
                bptr--;
            }
            ans += remainder % 2 + '0';
            remainder = remainder / 2;
        }
        std::reverse(ans.begin(), ans.end());
        return ans;
    }
};