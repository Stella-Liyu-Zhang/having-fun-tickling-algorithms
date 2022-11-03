import java.io.*;
import java.util.*;

class Solution {

    /*
     * answer:
     * key1 : 1,
     * key2.a : 2,
     * key2.b : 3,
     * key2.c.d: 3,
     * key2.c.e: 1,
     * key3 : 5
     * 
     * 
     * fun(key1, obj) -- string
     * fun(key2, obj) -> fun(key2.a, obj) - string
     * fun(key2.b, obj) - string
     * fun(key2.c, obj) -> fun(key2.c.d, obj) -- string
     * fun(key2.c.e, obj) -> fun(key2.c.e, obj) -- string
     * fun(key3, obj) -- string
     * 
     * dict = {
     * "Key1" : "1",
     * "Key2" : {
     * "a" : "2",
     * "b" : "3",
     * "c" : {
     * "d" : "3",
     * "e" : {
     * "" : "1"
     * }
     * }
     * },
     * "Key3" : "5",
     * }
     * Time Complexity: O(N), where N is the number of keys in the input dictionary.
     * We visit every key in dictionary only once, hence the linear time complexity.
     * Space Complexity: O(N) since the output dictionary is asymptotically as big
     * as the input dictionary.
     * We also store recursive calls in the execution stack which in the worst case
     * scenario could be O(N), as well. The total is still O(N).
     */
    // O(n) time | O(n) space
    static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
        HashMap<String, String> flattend = new HashMap<>();
        flattenHelper("", dict, flattend);
        return flattend;
    }

    static void flattenHelper(String currentKey, HashMap<String, Object> map, HashMap<String, String> result) {
        for (String childKey : map.keySet()) {
            String newKey = currentKey;
            if (currentKey.equals("")) {
                newKey = childKey;
            } else {
                newKey = childKey.equals("") ? newKey : newKey + "." + childKey;
            }

            if (map.get(childKey) instanceof HashMap) {
                flattenHelper(newKey, (HashMap) map.get(childKey), result);
            } else {
                result.put(newKey, String.valueOf(map.get(childKey)));
            }
        }
    }

}