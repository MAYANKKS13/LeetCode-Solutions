package org.example.LinkedList;

/*
3217. Delete Nodes from Linked List

You are given an array of integers nums and the head of a linked list.

Return the head of the modified linked list after removing all nodes from the linked list that have a value that exists in nums.

Example 1:

Input: nums = [1,2,3], head = [1,2,3,4,5]
Output: [4, 5]
Explanation: Remove the nodes with values 1, 2, and 3.

Example 2:

Input: nums = [1], head = [1,2,1,2,1,2]
Output: [2, 2, 2]
Explanation: Remove the nodes with value 1.

Example 3:

Input: nums = [5], head = [1,2,3,4]
Output: [1, 2, 3, 4]
Explanation: No node has value 5.
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

import java.util.HashSet;
import java.util.Set;

public class DeleteNodes {
    public static ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums) {
            set.add(num);
        }

        if(head == null) {
            return null;
        }

        ListNode current = head;
        while(current != null && current.next != null) {
            if(set.contains(current.next.val)) {
                current.next = current.next.next;
            }
            else {
                current = current.next;
            }
        }
        if(head != null && set.contains(head.val)) {
            head = head.next;
        }
        return head;
    }
}
