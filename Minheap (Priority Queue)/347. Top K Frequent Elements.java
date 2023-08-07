class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        maxHeap.addAll(map.keySet());

        int[] output = new int[k];
        while (!maxHeap.isEmpty() && k - 1 >= 0) {
            int curr = maxHeap.remove();
            output[k - 1] = curr; // k-1 -> 0
            k--;
        }
        return output;
    }
}