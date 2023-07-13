class Solution {
    public int longestPalindrome(String[] words) {
        // Create map
        HashMap<String, Integer> map = new HashMap<>();

        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int count = 0;
        int length = 0;
        boolean flag = false;
        for (String s : map.keySet()) {
            String reverse = new StringBuilder(s).reverse().toString();
            if (s.charAt(0) == s.charAt(1)) {
                // "nn", "bb"
                count = map.get(s);
                if (count % 2 != 0) {
                    count--;
                    flag = true;
                }
                length += count * 2;
            } else if (s.charAt(0) != s.charAt(1) && map.containsKey(reverse)) {
                int minLength = Math.min(map.get(s), map.get(reverse));
                length += minLength * 4;
                map.replace(s, 0);
            }
        }
        if (flag) {
            length += 2;
        }
        return length;
    }
}