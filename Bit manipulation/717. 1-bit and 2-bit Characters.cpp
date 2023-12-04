class Solution
{
public:
    /*
    0
    10, 11
    1, 01 are invalid
    */
    bool isOneBitCharacter(vector<int> &bits)
    {
        int i = 0;
        int n = bits.size();
        while (i <= n - 2)
        {
            if (bits[i] == 0)
            {
                i++;
            }
            else
            {
                i = i + 2;
            }
        }
        if (i <= n - 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
};