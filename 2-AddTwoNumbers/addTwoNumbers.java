/*
*   You are given two non-empty linked lists representing two non-negative integers.
*   The digits are stored in reverse order and each of their nodes contain a single digit.
*   Add the two numbers and return it as a linked list.
*   You may assume the two numbers do not contain any leading zero, except the number 0 itself.
*
*   (2->4->3) + (5->6->4) = (7->0->8)
*/

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        dummy.next = l2;
        ListNode prev = dummy;
        int carry = 0;
        
        while (l1 != null || l2 != null) {
            int tmp1 = l1 == null ? 0 : l1.val;
            int tmp2 = l2 == null ? 0 : l2.val;
            int digit = tmp1 + tmp2 + carry;
            carry = digit / 10;
            digit = digit % 10;
            
            if (l1 != null) {
                l1.val = digit;
                prev = l1;
                l1 = l1.next;
                if (l2 != null) l2 = l2.next;
            } else {
                l2.val = digit;
                prev.next = l2;
                prev = l2;
                l2 = l2.next;
            }
        }
        if (carry > 0) prev.next = new ListNode(carry);
        return dummy.next;
    }
}
