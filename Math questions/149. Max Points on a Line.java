class Solution {
    /*
    point[i][j] point[i+1][j+1] point[i+2][j+2]
    point[i][j] point[i-1][j+1] point[i-2][j+2]

    Time: O(n^2)
    insert into hm -> O(1)
    Space: O(n)
    */
    public int maxPoints(int[][] points) {
        int len = points.length;
        if (len == 1){
            return 1;
        }
        int result = 0;
        for(int i = 0; i < len; i ++){
            Map<Double, Integer> map = new HashMap<>();
            for(int j = 0; j < len; j ++){
                if (i != j){
                    //calculate the slope 
                    double slope = calculateSlope(points[i], points[j]);
                    map.put(slope, map.getOrDefault(slope, 0) + 1);
                    result = Math.max(result, map.get(slope));
                }
            }
        }
        return result + 1;
    }
    private double calculateSlope(int[] pointA, int[] pointB){
        // if (pointA[0] == pointB[0]){
        //     return Double.MAX_VALUE;
        // }else if (pointA[1] == pointB[1]){
        //     return 0;
        // }
        return (double)(pointB[1] - pointA[1])/(double)(pointB[0] - pointA[0]);
    }
}