#include <iostream>

vector<vector<int>> FlipAndInvertImage(vector<vector<int>> image)
{
    int row_count = image.size();
    int mid = (row_count + 1) / 2;

    for (auto &row : image)
    {
        for (int i = 0; i < mid; i++)
        {
            int temp = row[i] ^ 1;
            row[i] = row[row.size() - 1 - i] ^ 1;
            row[row.size() - 1 - i] = temp;
        }
    }
    return image;
}