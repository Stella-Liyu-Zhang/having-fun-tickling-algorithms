//Initial Solution that does not work:
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        if (asteroids.length < 2){
            return asteroids;
        }
        stack.push(asteroids[0]);
        for(int i = 1; i < asteroids.length; i ++){
            if(asteroids[i]*stack.peek()<0){
                if(Math.abs(asteroids[i]) > Math.abs(stack.peek())){
                    stack.pop();
                    stack.push(asteroids[i]);
                }
            }else{
                stack.push(asteroids[i]);
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        while(!stack.isEmpty()){
            ans.add(stack.pop());
        }
        Integer[] intArray = ans.toArray(new Integer[0]);
        int[] resultArray = new int[intArray.length];
        for (int i = 0; i < intArray.length; i++) {
            resultArray[i] = intArray[i];
        }

        return resultArray;
    }
}

// Accepted solution:
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while(i < asteroids.length){
            if(asteroids[i] > 0){
                stack.push(asteroids[i]);
            }else{ //negative
                while(stack.isEmpty() == false && stack.peek() > 0 && stack.peek() < Math.abs(asteroids[i])){
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek() < 0){
                    stack.push(asteroids[i]);
                } else if (stack.peek() == -1*asteroids[i]){
                    stack.pop();
                }
            }
            i++;
        }
        int[] ans = new int[stack.size()];
        for(int j = stack.size() - 1; j >= 0; j --){
            ans[j] = stack.pop();
        }
        return ans;
    }
}