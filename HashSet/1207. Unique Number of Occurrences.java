class Solution {
    /*
    key: Integer arr[i]
    value: Integer #occurence of arr[i]

    if map values are all distinct -> return true

    */
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: arr){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        HashSet<Integer> set = new HashSet<>(map.values());
        return set.size() == map.size();
    }
}