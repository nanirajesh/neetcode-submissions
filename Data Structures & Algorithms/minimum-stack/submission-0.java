class MinStack {

   Stack<Integer> stack;
   Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
   public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty()){
            minStack.push(x);
        }else{
            if(x<=minStack.peek()){
                minStack.push(x);
            }
        }
    }
    
    public void pop() {
        int stackTop=stack.pop();
        int minTop=minStack.peek();
        if(stackTop==minTop){
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
