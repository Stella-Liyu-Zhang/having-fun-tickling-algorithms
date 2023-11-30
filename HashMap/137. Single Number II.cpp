class Solution
{
public:
    /*
    1. unordered_map
    key: int
    value: occurence
    if value == 1, return the key
    */
    int singleNumber(vector<int> &nums)
    {
        unordered_map<int, int> map;
        for (auto n : nums)
        {
            map[n]++;
        }
        for (auto i : map)
        {
            if (i.second == 1)
            {
                return i.first;
            }
        }
        return -1;
    }
};