package stack;

import com.sun.security.jgss.InquireSecContextPermission;

public class SimpleStack {
    private static class Node{
        private int data;
        private Node next;
        private Node(int data){
            this.data = data;
        }
    }

    private Node top;

    public boolean isEmpty(){
        return top == null;
    }

    public int peek(){
        return top.data;
    }

    public void push(int data){
        Node node = new Node(data);
        node.next = top;
        top = node;
    }

    public int pop(){
        int data = top.data;
        top = top.next;
        return data;
    }

    private void print() {
        System.out.println("Elements of stack : ");
        int data;
        while (top != null){
            data = this.pop();
            System.out.println(data);
        }
    }

    public static void main(String[] args) {
        SimpleStack simpleStack = new SimpleStack();
        int data;
        Integer[] dataItems = new Integer[]{1, 2, 3, 4, 5};
        for (int i = 0; i <dataItems.length ; i++) {
            data = dataItems[i];
            simpleStack.push(data);
        }
        simpleStack.print();
    }


}
