class MedianFinder {
    private PriorityQueue<Integer> smallHeap;
    private PriorityQueue<Integer> largeHeap;

    public MedianFinder() {
        smallHeap = new PriorityQueue<>(Collections.reverseOrder());
        largeHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        smallHeap.offer(num);
        largeHeap.offer(smallHeap.poll());
   

        if (largeHeap.size() > smallHeap.size()) {
            smallHeap.offer(largeHeap.poll());
        }
    }
    
    public double findMedian() {
        if (largeHeap.size() == smallHeap.size()) {
            return (double) (largeHeap.peek() + smallHeap.peek())/2;
        }
        System.out.println(smallHeap);
        System.out.println(largeHeap);
        return smallHeap.peek();
    }
}
