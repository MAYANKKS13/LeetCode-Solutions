package org.example.Stack;

/*
20. Valid Parentheses

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

Example 1:

Input: s = "()"
Output: true

Example 2:

Input: s = "()[]{}"
Output: true

Example 3:

Input: s = "(]"
Output: false
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Map<Character, Integer> lookup = new HashMap();
        lookup.put('(', -1);
        lookup.put(')', 1);
        lookup.put('{', -2);
        lookup.put('}', 2);
        lookup.put('[', -3);
        lookup.put(']', 3);

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(lookup.get(c) > 0 && !stack.empty() && (lookup.get(c) + stack.peek()) == 0){
                stack.pop();
            } else {
                stack.push(lookup.get(c));
            }
        }
        return stack.empty();
    }
}
