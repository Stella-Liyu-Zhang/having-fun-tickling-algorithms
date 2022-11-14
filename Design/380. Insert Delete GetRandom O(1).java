/**
 * Space O(N), time O(1)
 * Set: insert O(1), remove O(1)
 * 
 * 
 * getRandom to be O(N), convert the set to the list is linear time O(n)
 * 
 * Optimal Approach:
 * HashMap<Integer, Integer>, value, index of the value in our arrayList
 * ArrayList(resizable array)
 */

class RandomizedSet {
    private HashMap<Integer, Integer> map;
    private List<Integer> list;
    private Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            map.put(val, list.size()); // add to map
            list.add(val); // add to list
            return true;
        }
    }

    public boolean remove(int val) {
        // normal remove is O(n), need to shift all the elements on the right.
        // so what we need to do is to remove the last element of the list instead.
        // [(1,0) (2, 1)]
        // [1, 2]
        if (!map.containsKey(val))
            return false;
        // Extract index of the value you want to remove: 0
        int index = map.get(val);
        // get last element in the list: 2
        int lastElement = list.get(list.size() - 1);
        // set the last element value to index: [2, 2]
        list.set(index, lastElement);
        // update the last elements index in our map (2,0)
        map.put(lastElement, index);
        // remove the entry containing the key equal to our value in map [(2,0)]
        map.remove(val);
        // remove the last element in our list [2]
        list.remove(list.size() - 1);
        return true;
    }

    public int getRandom() {
        // Returns number between 0 and list.size() - 1
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */