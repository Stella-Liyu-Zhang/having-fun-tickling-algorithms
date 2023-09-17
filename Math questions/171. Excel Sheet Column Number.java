class Solution {
    public int titleToNumber(String columnTitle) {
        int ans = 0;
        for(int i = 0; i < columnTitle.length(); i ++){
            ans = ans*26;
            ans += (columnTitle.charAt(i) - 'A' + 1);
        }
        return ans;
    }
}