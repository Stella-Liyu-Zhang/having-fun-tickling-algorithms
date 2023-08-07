/*
throw a hashmap
max heap!!!, organize all the elements
StringBuilder, remove things from the heap, throw it into it.
*/

class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // max heap building
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        maxHeap.addAll(map.keySet());
        StringBuilder sb = new StringBuilder();
        // loop through the maxHeap
        while (maxHeap.isEmpty() == false) {
            char curr = maxHeap.remove();
            for (int i = 0; i < map.get(curr); i++) {
                sb.append(curr);
            }
        }

        return sb.toString();
    }
}