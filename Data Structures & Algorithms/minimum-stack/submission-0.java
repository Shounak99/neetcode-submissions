class MinStack {
    Stack<Integer> currState;
    Stack<Integer> minStack;
    public MinStack() {
        currState=new Stack<>();
        minStack=new Stack<>();
    }
    
    public void push(int val) {
        currState.push(val);
        
        if(minStack.isEmpty() || minStack.peek()>=val){
            minStack.push(val);
        }
    }
    
    public void pop() {
        int val=currState.pop();
        if(val==minStack.peek()){
            minStack.pop();
        }
    }
    
    public int top() {
        return currState.peek();
        
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
