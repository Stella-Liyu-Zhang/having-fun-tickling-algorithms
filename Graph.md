## BFS

Vertices = numbers
Edges = index neighbors

- Queue:

### Easy way to represent node:

1. class Coord: x, y
2. String "x,y"

- problem: hard to coordinate from string to integer back to coordinates

3. Array [x,y]
   - writing a lot of codes
4. Integer Representation
   x,y -> z

```
    Queue[1 5]
    2D -> 1D
    X* COLS + Y
    columns = 3
    x,y = (0,1) = 0*3 + 1 = 1

    convert the integer back to the coordinate
    1D to 2D
    row = index/cols,
    col = index % cols
```

## Simplifying BFS algo

look up, down left, right for every single vertices
![](assets/20221112185424.png)

## User input as the visited set

func solve (int[][] matrix)
