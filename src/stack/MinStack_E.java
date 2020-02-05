package stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ziweihan on 4/9/19.
 *
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.
 Example:
 MinStack_E minStack = new MinStack_E();
 minStack.push(-2);
 minStack.push(0);
 minStack.push(-3);
 minStack.getMin();   --> Returns -3.
 minStack.pop();
 minStack.top();      --> Returns 0.
 minStack.getMin();   --> Returns -2.
 */
public class MinStack_E {

    /** initialize your data structure here. */
    List<Integer> stack ;

    public MinStack_E() {
      stack = new ArrayList<>();
    }

    public void push(int x) {
        stack.add(x);
    }

    public void pop() {
        if(stack.isEmpty())
            return;
        stack.remove(stack.size()-1);
    }

    public int top() {
        return stack.get(stack.size()-1);
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        for(int element: stack){
            min = Math.min(min, element);
        }
        return min;
    }

    public static void main(String[] args){

    }
}
