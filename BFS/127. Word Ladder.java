class Solution {
    /*
    graph node -> node
    wordList
    if any 2 words differ by 1 character, then there is an edge between which
    BFS
    Queue, set

    Time: O(M^2*N)
    Space Complexity: O(N)
    */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList();
        HashSet<String> wordSet = new HashSet(wordList);
        queue.add(beginWord);

        int count = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i ++){
                char[] curr = queue.remove().toCharArray();

                for(int j = 0; j < curr.length; j ++){
                    char temp = curr[j];
                    //change one letter at a time
                    for(char c = 'a'; c <= 'z'; c++){
                        curr[j] = c;
                        String neighbor = new String(curr);
                        //shen the next word is in the set
                        if(wordSet.contains(neighbor)){
                            if(neighbor.equals(endWord)){
                                return count + 1;
                            }else{
                                queue.offer(neighbor);
                                wordSet.remove(neighbor);
                            }
                        }
                    }
                    //have to undo for the next chnage of letter
                    curr[j] = temp;
                }

            }
            count ++;
        }
        return 0;
    }
}