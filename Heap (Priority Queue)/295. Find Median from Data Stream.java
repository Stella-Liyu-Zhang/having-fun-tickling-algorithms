class MedianFinder {
    /*
    return the median value
    Brutal force:
    use a data structure, put the integer to our list
    sort the data structure, choose a median value

    use some data structure with ordering
    - heap
    one heap ascending -> peek() is the small number
    the other descending -> peek() is the largest number

    minHeap -> save large values - minSize
    maxHeap -> save small values - maxSize

    Cases: addNum(int num)
    0: minSize == 0: add num to minHeap
    1: maxSize == 0 if num < minHeap.peek() //return the smallest number in minHeap
                    maxHeap.offer(num)
                    else 
                    swap
        make sure that minHeap -> large
                        maxHeap -> small

    2: num < minHeap.peek()
    3: save num -> minHeap

    Make sure the size difference between minHeap and maxHap is <=1
    private void balance(){
        if(|minSize - maxSize| <= 1) return
        if maxSize > minSize
            offer 1 element from maxHeap to minHeap

        else
            offer 1 element from minHeap to maxHeap
    }

    */
    private PriorityQueue<Integer> minHeap; //save large values
    private PriorityQueue<Integer> maxHeap; //save small values

    private int minSize;
    private int maxSize;
  
    public MedianFinder() {
         minHeap = new PriorityQueue<>();
         maxHeap = new PriorityQueue<>(Collections.reverseOrder());
         minSize = 0;
         maxSize = 0;
    }
    
    public void addNum(int num) {
        if(minSize == 0){
            minHeap.offer(num);
            minSize ++;
            return;
        }
        if(maxSize == 0){
            if(num < minHeap.peek()){
                maxHeap.offer(num);
            }else{
                maxHeap.offer(minHeap.poll());
                minHeap.offer(num);
            }
            maxSize ++;
            return;
        }
        if(num < minHeap.peek()){
            maxHeap.offer(num);
            maxSize ++;
        }else{
            minHeap.offer(num);
            minSize ++;
        }
        balance();
    }

    private void balance(){
        if(Math.abs(minSize - maxSize) <= 1){
            return;
        }
        if(maxSize > minSize){
            minHeap.offer(maxHeap.poll());
            minSize ++;
            maxSize --;
        }else{
            maxHeap.offer(minHeap.poll());
            maxSize ++;
            minSize --;
        }
    }
    
    public double findMedian() {
        if(maxSize > minSize){
            return maxHeap.peek();
        }else if (maxSize < minSize){
            return minHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */