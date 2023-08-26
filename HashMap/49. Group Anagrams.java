class Solution {
    /*
     * 1) occurence table int[] arr = new int[26];
     * 2) az --> 100000000001
     * 3) key: 111 -string
     * value: "eat" "tae"....
     * 4) looping through the map, check keys are the same, group the values
     * n strings
     * average of n chars per string
     * O(mn)
     * 
     * L naagrams
     * space: 26*n + L
     * 
     * (nmlogm) if using sort
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] arr = new char[26];
            for (char c : s.toCharArray()) {
                arr[c - 'a']++;
            }
            String occ = new String(arr);
            /*
             * char[] c = s.toCharArray();
             * Array.sort(c);
             * String key = String.valueOf(c);
             */
            List<String> tempList = map.getOrDefault(occ, new ArrayList<>());
            tempList.add(s);
            map.put(occ, tempList);
        }
        return new ArrayList<>(map.values());
    }
}