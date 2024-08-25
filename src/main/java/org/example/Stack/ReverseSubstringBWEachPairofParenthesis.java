package org.example.Stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseSubstringBWEachPairofParenthesis {
    public static void main(String[] args) {
        String s = "(u(love)i)";
        String s1 = "(ed(et(oc))el)";
        String s2 = "(abcd)";
        System.out.println(reverseParenthesis(s));
        System.out.println(reverseParenthesis(s1));
        System.out.println(reverseParenthesis(s2));
    }

    public static String reverseParenthesis(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> tempStack = new Stack<>();
        String result = "";
        Queue<Character> queue = new LinkedList<>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ')') {
                while (stack.peek() != '(') {
                    queue.add(stack.pop());
                }
                stack.pop();
                while (queue.size() > 0) {
                    stack.push(queue.peek());
                    queue.remove();
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }
        while (!tempStack.isEmpty()) {
            result = result + tempStack.pop();
        }
        return result;
    }
}
