class MyStack {
    private Queue<Integer> main;
    private Queue<Integer> helper;

    public MyStack() {
        main=new LinkedList<>();
        helper=new LinkedList<>();

    }
    
    public void push(int x) {
        //main to helper
        //add element to main
        //move whole helper to main

        while(main.size()>0){
            helper.add(main.remove());
        }

        main.add(x);

        while(helper.size()>0){
            main.add(helper.remove());
        }
    }
    
    public int pop() {
        return main.remove();
    }
    
    public int top() {
        return main.peek();
    }
    
    public boolean empty() {
        if(main.size()==0){
            return true;
        }
        else{
            return false;
        }
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */