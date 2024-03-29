class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses]; //how many prerequisites a particular class have

        for(int[] pre: prerequisites){
            //indegree
            indegree[pre[0]] ++;
        }

        Set<Integer> zeroDegree = new HashSet(); //set of classes that require no prerequisites

        for(int i = 0; i < numCourses; i++){
            if (indegree[i] == 0){
                zeroDegree.add(i);
            }
        } 
        if(zeroDegree.isEmpty()){
            return false;
        }
        while(!zeroDegree.isEmpty()){
            Iterator<Integer> it = zeroDegree.iterator();
            int course = it.next();
            zeroDegree.remove(course);
            for(int[] pre: prerequisites){
                if (course == pre[1]){
                    indegree[pre[0]] --;
                    if (indegree[pre[0]] == 0){
                        zeroDegree.add(pre[0]);
                    }
                }
            }
        }

        for(int num: indegree){
            if(num != 0){
                return false;
            }
        }
        return true;
    }
}