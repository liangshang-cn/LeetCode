// 链表排序 要求O(nlogn)时间复杂度 O(1)空间复杂度

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)  {return head;}
        int len = countLength(head);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //i 表示每轮归并的长度
        for (int i = 1; i < len; i = i * 2) {
            ListNode node = dummy;
            // j 表示本轮归并中每段的起点
            for (int j = 0; j + i < len; j += 2 * i) {
                // first指向第一段归并起点
                ListNode first = node.next;
                // second指向第二段归并起点
                ListNode second = first;
                for (int k = 0; k < i; k++) {
                    second = second.next;
                }
                //下面这段代码完成两段的归并
                int p1 = 0, p2 = 0;
                while (p1 < i && p2 < i && second != null) {
                    if (first.val <= second.val) {
                        node.next = first;
                        first = first.next;
                        p1++;
                    } else {
                        node.next = second;
                        second = second.next;
                        p2++;
                    }
                    node = node.next;
                }
                while (p1 < i) {
                    node.next = first;
                    first = first.next;
                    p1++;
                    node = node.next;
                }
                while (p2 < i && second != null) {
                    node.next = second;
                    second = second.next;
                    p2++;
                    node = node.next;
                }
                node.next = second;
            }
        }
        return dummy.next;
    }
    private int countLength(ListNode head) {
        ListNode node = head;
        int n = 0;
        while (node != null) {
            node = node.next;
            n++;
        }
        return n;
    }
}
