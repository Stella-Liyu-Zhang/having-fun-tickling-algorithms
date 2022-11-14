class OrderedStream {
    // Basically, the idea is that you need to return a longest list that start at
    // index of ptr. if ptr is not pointing at an element, you need to return a
    // empty list.

    int ptr = 0;
    String[] stream = {};

    public OrderedStream(int n) {
        // n is the length of the stream
        // Constructs the stream to take n values.
        ptr = 0;
        stream = new String[n];
    }

    public List<String> insert(int idKey, String value) {
        List<String> ans = new ArrayList<>();

        // insert the key, value pair into stream
        stream[idKey - 1] = value;

        while (ptr < stream.length && stream[ptr] != null) {
            ans.add(stream[ptr]);
            ptr++;
        }
        return ans;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */