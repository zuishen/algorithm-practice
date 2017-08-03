/*
*   Merge two sorted linked lists and return it as a new list. (singly-linked list)
*   The new list should be made by splicing together the nodes of the first two lists. (splice 拼接)
*
*   public class ListNode {
*       int val;
*       ListNode next;
*       ListNode(int x) {val = x;}
*/

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curt = dummy;    
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curt.next = l1;
                l1 = l1.next;
                curt.next.next = null;
                curt = curt.next;
            } else {
                curt.next = l2;
                l2 = l2.next;
                curt.next.next = null;
                curt = curt.next;
            }
        }
        if (l1 != null) {
            curt.next = l1;   
        }
        if (l2 != null) {
            curt.next = l2;   
        }
        return dummy.next;
    }
}


