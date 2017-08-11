/*
*   Given a sorted linked list, delete all duplicates such that each element appear only once.
*   1->1->2->3->3  ==> 1->2->3
*/
//  Definition of singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}

//  最开始考虑的是使用双指针，slow指向当前node，fast向前测试，当slow.val != fast.val 时删去所有重复。每次循环都会将fast向后一个。
//  这个问题在于最后面所有相同的element无法处理，需要在循环结束后，执行 if(slow != null) slow.next = null;

//  其实只要一个curr指针就可以，每次与自己的next进行比较，如果相同的话，则丢弃下一个。(一边循环一边删去相同)
