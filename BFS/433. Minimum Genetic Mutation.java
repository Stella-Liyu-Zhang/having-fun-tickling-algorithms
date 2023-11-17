class Solution {
    /*
    Would be easier if valid string constraint in bank, just need to check the different character amount

    initial -> goal state, we use graph!
    traverse the graph
    
    BFS: 
    amone the new genes, we enqueue nonly those that are in the bank and still unvisited.
    keep track of how many mutations we need to reach the actual stage.

    convert the bank to a set
    if end is not in bank, return -1

    perform the 32 mutations

    if not visited and in the bank, then enqueue.

    Time O(N), where N is bank.length
    Space: O(!), because the problem limits the input explicity
    */
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if(!bankSet.contains(endGene)){
            return -1;
        }
        if(startGene.equals(endGene)){
            return 0;
        }
        Queue<String> queue = new LinkedList();
        Set<String> visited = new HashSet();

        queue.offer(startGene);
        visited.add(startGene);
        int steps = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int j = 0; j < size; j ++){
                String curr = queue.remove();
                if(curr.equals(endGene)){
                    return steps;
                }
                for(int i = 0; i < curr.length(); i ++){
                    for(char c: new char[]{'A', 'C', 'G', 'T'}){
                        String neighbor = curr.substring(0,i) + c + curr.substring(i+1);
                        if(!visited.contains(neighbor) && bankSet.contains(neighbor)){
                            queue.offer(neighbor);
                            visited.add(neighbor);
                        }

                    }
                }
            }
            steps++;
        }
        return -1;

    }
}