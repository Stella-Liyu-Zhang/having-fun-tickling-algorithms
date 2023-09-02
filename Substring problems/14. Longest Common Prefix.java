class Solution {
    /*
    sort the strs
    compare the first and last element

    */
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1){
            return strs[0];
        }
        Arrays.sort(strs);
        int i = 0;
        while(i < strs[0].length()){
            if(strs[0].charAt(i) != strs[strs.length - 1].charAt(i)){
                break;
            }
            i++;
        }
        return strs[0].substring(0,i);
    }
}