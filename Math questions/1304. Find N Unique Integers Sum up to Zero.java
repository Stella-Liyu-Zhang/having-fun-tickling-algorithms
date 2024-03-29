class Solution {
    /*
    N is odd:
    0, -1, 1, -2, 2, ... 
    n is even:
    -1,1,-2,2,....
    */
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        for(int i = 1; i < n; i = i + 2){
            ans[i-1] = i;
            ans[i] = -i;
        }
        if(n % 2 == 1){
            ans[n-1] = 0;
        }
        return ans;
    }
}