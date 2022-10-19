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

If you're only interested in the keys, you can iterate through the keySet() of the map:

```java
Map<String, Object> map = ...;

for (String key : map.keySet()) {
    // ...
}
```

If you only need the values, use values():

```java
for (Object value : map.values()) {
    // ...
}
```

Finally, if you want both the key and value, use entrySet():

```java
for (Map.Entry<String, Object> entry : map.entrySet()) {
    String key = entry.getKey();
    Object value = entry.getValue();
    // ...
}
```
