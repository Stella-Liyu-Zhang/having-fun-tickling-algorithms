class Solution {
    /*
    Arrays.stream(candies).max().getAsInt() is O(n), and space is O(1)
    Time: O(n)
    Space: O(n)
    */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        //Get the current most candies
        int max = Arrays.stream(candies).max().getAsInt();
        List<Boolean> ans = new ArrayList<>();
        //loop through candies
        for(int i: candies){
            if(i+extraCandies >= max){
                ans.add(true);
            }else{
                ans.add(false);
            }
        }
        return ans;
    }
}