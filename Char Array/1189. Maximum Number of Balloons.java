class Solution {
    //Time: O(n), space: O(1)
    public int maxNumberOfBalloons(String text) {
        int[] arr = new int[26];
        for(char c: text.toCharArray()){
            arr[c-'a'] ++;
        }
        for(int i = 0; i < 26; i ++){
            System.out.println(arr[i]);
        }
        //b -> 1
        int min = arr[1];
        //a -> 0
        min = Math.min(min, arr[0]);
        //l -> 11
        min = Math.min(min, arr[11]/2);
        // o -> 14
        min = Math.min(min, arr[14]/2);
        // n -> 13
        min = Math.min(min, arr[13]);

        return min;
    }
}