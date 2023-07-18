class Solution {
    //find a deadlock  
    //use directed graph: src --> destination
    //cycle detection: graph coloring: O(V+E)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new List[numCourses];
        int[] indegree = new int[numCourses];
        List<Integer> ans = new ArrayList<>();

        for(int[] pair: prerequisites){
            int course = pair[0];
            int prereq = pair[1];
            if (adj[prereq] == null){
                adj[prereq] = new ArrayList<>();
            }
            adj[prereq].add(course);
            indegree[course]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if (indegree[i] == 0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int curr = queue.poll();
            ans.add(curr);

            if (adj[curr] != null){
                for(int next: adj[curr]){
                    indegree[next] --;
                    if (indegree[next] == 0){
                        queue.offer(next);
                    }
                }
            }
        }
        return ans.size() == numCourses;

    }
}