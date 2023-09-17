class Solution {
    /*
    1 2 3 4 5 6 

    */
    public int countOdds(int low, int high) {
        int ans = 0;
        if(low % 2 == 0 && high % 2 == 0){
            ans = (high - low)/2;
        }else if(low %2 == 1 && high % 2 == 1){
            ans = (high - low)/2 + 1;
        }else{
            ans = (high - low)/2 + 1;
        }
        return ans;
    }
}