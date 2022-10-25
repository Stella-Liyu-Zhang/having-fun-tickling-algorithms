## Get Or Default

If the key "y" does not exist, we will return the value "500" as default.

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

## Iterating through the keyset()

If you're only interested in the keys, you can iterate through the keySet() of the map:

```java
Map<String, Object> map = ...;

for (String key : map.keySet()) {
    // ...
}
```

## Iterating through the values()

If you only need the values, use values():

```java
for (Object value : map.values()) {
    // ...
}
```

## Iterating through both the keys and the values

Finally, if you want both the key and value, use entrySet():

```java
for (Map.Entry<String, Object> entry : map.entrySet()) {
    String key = entry.getKey();
    Object value = entry.getValue();
    // ...
}
```

## Creating a new hashmap with insert, get addToKey, addToValue methods

```java
You've created a new programming language, and now you've decided to add hashmap support to it. Actually you are quite disappointed that in common programming languages it's impossible to add a number to all hashmap keys, or all its values. So you've decided to take matters into your own hands and implement your own hashmap in your new language that has the following operations:

insert x y - insert an object with key x and value y.
get x - return the value of an object with key x.
addToKey x - add x to all keys in map.
addToValue y - add y to all values in map.
To test out your new hashmap, you have a list of queries in the form of two arrays: queryTypes contains the names of the methods to be called (eg: insert, get, etc), and queries contains the arguments for those methods (the x and y values).

Your task is to implement this hashmap, apply the given queries, and to find the sum of all the results for get operations.

Example

For queryType = ["insert", "insert", "addToValue", "addToKey", "get"] and query = [[1, 2], [2, 3], [2], [1], [3]], the output should be hashMap(queryType, query) = 5.

The hashmap looks like this after each query:

1 query: {1: 2}
2 query: {1: 2, 2: 3}
3 query: {1: 4, 2: 5}
4 query: {2: 4, 3: 5}
5 query: answer is 5
The result of the last get query for 3 is 5 in the resulting hashmap.

For queryType = ["insert", "addToValue", "get", "insert", "addToKey", "addToValue", "get"] and query = [[1, 2], [2], [1], [2, 3], [1], [-1], [3]], the output should be hashMap(queryType, query) = 6.

The hashmap looks like this after each query:

1 query: {1: 2}
2 query: {1: 4}
3 query: answer is 4
4 query: {1: 4, 2: 3}
5 query: {2: 4, 3: 3}
6 query: {2: 3, 3: 2}
7 query: answer is 2
The sum of the results for all the get queries is equal to 4 + 2 = 6.
```

```java

long solution(String[] queryType, int[][] query) {
  int curKeyInc = 0;
  int curValInc = 0:
  HashMap<Integer, Integer> mp = new HashMaps<>():
  long ans = 0;
  for (int i = 0; i < queryType.length; i++) {
    if (queryType[i].equals("insert")) {
      mp.put(query[i][0] - curKeyInc, query[i][1] - curValInc);
    } else if (queryType[i].equals("addToValue")) {
      curValInc += query[i][0];
    } else if (queryType[i].equals("addToKey")) {
      curKeyInc += query[i][0];
    } else {
      ans += mp.getOrDefault(query[i][0] - curkeyInc, -1 * curValInc) + curValInc;
    }
    return ans;
  }
}

```

## Sort a Hashmap according to the key

```java
  // TreeMap to store values of HashMap
  TreeMap<String, Integer> sorted = new TreeMap<>();

  // Copy all data from hashMap into TreeMap
  sorted.putAll(map);

  // Display the TreeMap which is naturally sorted
  for (Map.Entry<String, Integer> entry : sorted.entrySet())
  System.out.println("Key = " + entry.getKey() +", Value = " + entry.getValue());

```

## Sort a Hashmap according to the value

## Sort a hashmap according to values -descending order
