package org.example.Stack;

/*
155. Min Stack

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 */

/*
-----------------------------------NOTE-----------------------------------------
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
*/

public class MinStack {

    Node node;

    public MinStack() {

    }

    public void push(int val) {
        if(node == null) {
            node = new Node(val, val);
        } else {
            Node newNode = new Node(val, Math.min(val, node.min));
            newNode.next = node;
            node = newNode;
        }
    }

    public void pop() {
        if(node == null) {
            return;
        }
        node = node.next;
    }

    public int top() {
        return node.data;
    }

    public int getMin() {
        return node.min;
    }
}

class Node {
    int data;
    int min;
    Node next;

    Node(int data, int min){
        this.data = data;
        this.min = min;
    }
}
