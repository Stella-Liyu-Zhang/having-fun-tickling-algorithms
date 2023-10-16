class Solution {
    /*
    If 5, 2, 
    10,
    5, 20
    50, 2,..
    Count the number of 2, 20,...
    count the number of 5, 50,... and get the minimum of these 2
    count the number of 10, 100,...


    */
    public int trailingZeroes(int n) {
        int fives = 0;
        for(int i = 1; i <= n; i ++){
            int currFactor = i;
            while(currFactor % 5 == 0){
                fives ++;
                currFactor = currFactor/5;
            }
        }
        return fives;
    }
}