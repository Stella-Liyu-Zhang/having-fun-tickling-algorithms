
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue(new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                int frequency1 = map.get(word1);
                int frequency2 = map.get(word2);
                if (frequency1 == frequency2)
                    return word2.compareTo(word1);
                else
                    return frequency1 - frequency2;
            }
        });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.add(entry.getKey());
            if (pq.size() > k)
                pq.poll();
        }
        List<String> output = new ArrayList<>();
        while (!pq.isEmpty()) {
            output.add(pq.poll());
        }
        Collections.reverse(output);
        return output;

    }
}

class Solution {
    /*
    min heap of size k to store the largest k elements so far,

    The PriorityQueue is initialized with a comparator. This comparator will determine the order in which elements are dequeued from the priority queue.

    */
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList();
        HashMap<String, Integer> map = new HashMap();
        for(String s: words){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>(
            (s1, s2) -> map.get(s1).equals(map.get(s2)) ? s2.compareTo(s1) : map.get(s1) - map.get(s2));

        for(String s: map.keySet()){
            pq.offer(s);
            if(pq.size() > k){
                pq.poll();
            }
        }
        while(pq.isEmpty() == false){
            res.add(pq.poll());
        }
        Collections.reverse(res);
        return res;
    }
}