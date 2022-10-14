class Solution {
    public int firstUniqChar(String s) {
        // use a data structure to keep track how many times a character occurs
        // hashmap with key as the character, the number as how many times it appears.
        // {'a':0 , 'b':0, }
        // hashmap put and get operation is O(1)
        // O(2n) = O(n)

        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

        for (Character c : s.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        System.out.println(hm);
        for (int i = 0; i < s.length(); i++) {
            if (hm.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}