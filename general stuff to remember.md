## Convert to double, double representation

For this code block:

```java
int num = 5;
int denom = 7;
double d = num / denom;
```

The value of d is 0.0. It can be forced to work by casting:

```java
double d = ((double) num) / denom;
```
