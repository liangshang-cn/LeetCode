/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode node = dummy;
        int digit = 0;
        while (l1 != null || l2 != null || digit != 0) {
            int num = digit;
            if (l1 != null) {
                num += l1.val;
                l1 = l1.next;
            } 
            if (l2 != null) {
                num += l2.val;
                l2 = l2.next;
            }
            if (num >= 10) {
                digit = 1;
                num = num % 10;
            } else {
                digit = 0;
            }
            node.next = new ListNode(num);
            node = node.next;
        }
        return dummy.next;
    }
}
