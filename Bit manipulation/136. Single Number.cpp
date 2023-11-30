class Solution
{
public:
    /*
    number & number will always result in number.
    If we take XOR of zero and some bit, it will return that bit
    a⊕0=a
    If we take XOR of two same bits, it will return 0
    a⊕a=0
    */
    int singleNumber(vector<int> &nums)
    {
        int res = 0;
        for (int i : nums)
        {
            res ^= i;
        }
        return res;
    }
};