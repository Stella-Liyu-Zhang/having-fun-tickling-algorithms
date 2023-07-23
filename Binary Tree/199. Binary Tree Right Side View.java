/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/*
we can have a left child but the rightest in its level, doesn't need to be right child
1)BFS 
Queue, store treenodes [  4 , 5 , 6   ]
res = [ 1, 3 , 6  ]
size = 3， how many times we need to pull from the queue in order to perform our level order traversal
i = 0, iterate from 0 to size-1, a loop telling us that we need to pull from our queue that many times
i == size - 1, this is how we know we have the rightmost node from that level
time: O(N), n is number of nodes in our tree
Space: O(N), since our queue will grow to the size of our largest level containing N nodes
2) DFS
*/
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.isEmpty() == false){
            int size = queue.size();
            for(int i = 0; i < size; i ++){
                TreeNode node = queue.poll();
                if (i == size-1){
                    result.add(node.val);
                }
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return result;
    }
}

//Resursive method DFS
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        //recursive method DFS 
         List<Integer> visibleValues = new ArrayList<>();
         getRight(root, visibleValues, 0);
         return visibleValues;
        
    }
    public void getRight(TreeNode curr, List<Integer> list, int currDepth){
        if ( curr == null){
            return;
        }
        if(currDepth == list.size()){
            list.add(curr.val);
        }
        getRight(curr.right, list, currDepth + 1);
        getRight(curr.left, list, currDepth + 1);
    }
}