```java
 // Create a HashMap and add some values
HashMap<String, Integer> map = new HashMap<>();
map.put("a", 100);
map.put("b", 200);
map.put("c", 300);
map.put("d", 400);

// provide key whose value has to be obtained
// and default value for the key. Store the
// return value in k
int k = map.getOrDefault("y", 500);
```
