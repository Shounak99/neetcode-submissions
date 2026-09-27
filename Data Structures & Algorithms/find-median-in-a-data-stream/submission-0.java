class MedianFinder {
    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;
    int size;
    public MedianFinder() {
        min=new PriorityQueue<>();
        max=new PriorityQueue<>((a,b)->b-a);
        size=0;
    }
    
    public void addNum(int num) {
        if(min.isEmpty()||min.peek()<=num){
            min.add(num);
        }
        else if(!min.isEmpty() && min.peek()>num){
            max.add(num);
        }
        if(min.size()-max.size()>1){
            max.add(min.poll());
        }
        else if(max.size()>min.size()){
            min.add(max.poll());
        }
        size++;
    }
    
    public double findMedian() {    
        if(size%2==0){
            return (double) (max.peek()+min.peek())/2.0;
        }
        return min.peek();
        
    }
}
