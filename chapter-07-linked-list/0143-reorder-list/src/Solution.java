public class Solution {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        // 先找到中点
        ListNode n1 = head;
        ListNode n2 = head;
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }
        // 此时 n1 的位置就在中点，即分成 [0,n1] [n1+1,end]

        ListNode curNode = n1.next;
        n1.next = null;
        // 翻转链表

        ListNode pre = null;
        ListNode next;
        while (curNode != null) {
            next = curNode.next;
            curNode.next = pre;
            pre = curNode;
            curNode = next;
        }
        // 此时 pre 是翻转以后的链表头

        ListNode p1 = head;
        ListNode p2 = pre;

        while (p2 != null) {
            n1 = p1.next;
            n2 = p2.next;
            p1.next = p2;
            if (n1 == null) {
                break;
            }
            p2.next = n1;
            p1 = n1;
            p2 = n2;
        }
    }
}
