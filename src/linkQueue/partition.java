package linkQueue;
/**
 * @author Agnostic
 * 给定一个链表和一个值x，将链表划分成两部分，使得划分后小于x的结点在前
 * 大于等于x的结点在后，在这两部分中要保持原链表中的出现顺序(Leetcode 86)。
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 * 选出一个pivot，然后将序列分成两边，一边比pivot小，一边比pivot大，然后不断递归。
 * */
public class partition {
    public ListNode partition1(ListNode head, int x) {
        ListNode p1 = new ListNode(0);
		ListNode p2 = new ListNode(0);
		ListNode p1tail = p1;
		ListNode p2tail = p2;
		while (head != null)
		{
			if (head.val < x)
			{
				p1tail.next = head;
				p1tail = p1tail.next;
			}
			else
			{
				p2tail.next = head;
				p2tail = p2tail.next;
			}
			head = head.next;
		}
		p1tail.next = p2.next;
		p2tail.next = null;
		return p1.next;
    }
}
