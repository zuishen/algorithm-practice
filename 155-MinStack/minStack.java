/*
*   Design a stack that supports push, pop, top, and retrieving the minmum element in constant time.
*   push(x) -- Push element x onto stack.
*   pop() -- Removes the element on top of the stack.
*   top() -- Get the top element.
*   getMin()  -- Retrieve the minimum element in the stack.
*/

class MinStack {
    Stack<Integer> data;
    Stack<Integer> min;     
    // 用一个stack来保存最小的值，当新插入的数小于等于top时才入栈，因为新入栈的数如果一定会先被移除，所以如果大于栈顶的话没必要入栈
    // 需要等于，否则会空栈
    // 注意考虑为插入数字，而读取或移除的情况
    
    public MinStack() {
        this.data = new Stack<>();
        this.min = new Stack<>();
    }
    
    public void push(int x) {
        data.push(x);
        if (min.isEmpty() || x <= min.peek()) {
            min.push(x);
        }
    }
    
    public void pop() {
        if (data.isEmpty()) return;
        int x = data.pop();
        if (x == min.peek()) {
            min.pop();
        }
    }
    
    public int top() {
        return data.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
    
    
