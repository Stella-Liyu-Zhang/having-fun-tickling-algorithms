# Topological Sort

## Conditions

A topological ordering is possible if and only if the graph has no directed cycles, that is, if it is a directed acyclic graph (DAG).

> Is this a valid DAG?

- If a cycle exists, NO
  > Any DAG has at least one topological ordering, and algrithms are known for constructing a topological ordering of any DAG in linear time.

## Kahn's algorithm

```
L ← Empty list that will contain the sorted elements
S ← Set of all nodes with no incoming edge

while S is not empty do
    remove a node n from S
    add n to L
    for each node m with an edge e from n to m do
        remove edge e from the graph
        if m has no other incoming edges then
            insert m into S

if graph has edges then
    return error   (graph has at least one cycle)
else
    return L   (a topologically sorted order)
```
