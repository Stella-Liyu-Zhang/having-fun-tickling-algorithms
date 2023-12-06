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