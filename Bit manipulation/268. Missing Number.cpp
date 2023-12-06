class Solution
{
public:
    /*
    XOR each number in nums with the array that was supposed to be full from 0 to n

    */
    int missingNumber(vector<int> &nums)
    {
        int nums_size = nums.size();
        int missing = 0;
        for (int i = 0; i <= nums_size; i++)
        {
            missing = missing ^ i;
        }
        for (int i : nums)
        {
            missing = missing ^ i;
        }
        return missing;
    }
};

class Solution
{
public:
    int missingNumber(vector<int> &nums)
    {
        std::unordered_set<int> set;
        for (int n : nums)
        {
            set.insert(n);
        }
        for (int i = 0; i <= nums.size(); i++)
        {
            if (set.contains(i) == false)
            {
                return i;
            }
        }
        return -1;
    }
};