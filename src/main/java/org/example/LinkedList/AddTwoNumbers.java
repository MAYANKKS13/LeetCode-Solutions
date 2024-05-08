package org.example.LinkedList;

/*
2. Add Two Numbers

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
 */

/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        int carry = 0;
        while(l1!=null && l2!=null){
            int num1 = (l1==null)?0:l1.val;
            int num2 = (l2==null)?0:l2.val;
            temp.next = new ListNode((num1 + num2 + carry)%10);
            carry = (num1 + num2 + carry)/10;
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            int num1 = (l1==null)?0:l1.val;
            temp.next = new ListNode((num1 + carry)%10);
            carry = (num1 + carry)/10;
            temp = temp.next;
            l1 = l1.next;
        }

        while(l2 != null){
            int num1 = (l2==null)?0:l2.val;
            temp.next = new ListNode((num1 + carry)%10);
            carry = (num1 + carry)/10;
            temp = temp.next;
            l2 = l2.next;
        }

        // carry
        if(carry > 0)
            temp.next = new ListNode(carry);
        return result.next;
    }
}
