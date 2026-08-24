class MinStack {

     Stack<Integer> st=new Stack<>();
     Stack<Integer> Minst=new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int value) {
        if(st.isEmpty()){
            st.push(value);
            Minst.push(value);
        }
        else{
            st.push(value);
            if(Minst.peek()>value){
                Minst.push(value);
            }
            else{
                Minst.push(Minst.peek());
            }
        }
    }
    
    public void pop() {
        st.pop();
        Minst.pop();
    }
    
    public int top() {
    return st.peek();
    }
    
    public int getMin() {
          return Minst.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */