/*
The core idea of this algorithm:

1.Each depth of the tree only select one node.
2. View depth is current size of result list.

Space O(n): Queue size we allocated
Time O(n): went through the entire tree, n the number of nodes in our tree
*/
    
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        //top to botton: breadth firsth search
        List<Integer> visibleValues = new ArrayList<>();
        if (root == null){
            return visibleValues;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); 
        
        while(!queue.isEmpty()){
            TreeNode curr = root;
            int size = queue.size();
            for(int i = 0; i < size; i ++){
                curr = queue.remove();
                if (i == size - 1){
                    visibleValues.add(curr.val);
                }
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
        }
        return visibleValues;
        
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