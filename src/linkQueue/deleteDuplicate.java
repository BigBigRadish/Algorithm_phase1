/**
 * 
 */
package linkQueue;

/**
 * @author Agnostic
 * 给定排序的链表，删除重复元素，只保留重复元素第一次出现的结点（Leetcode 83）。
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * 由于是排好序的，碰到一个不同的值就保存起来，然后比较下一个结点的值是不是和它相同，
 * 如果相同则删掉这个结点，如果不同则改变保存起来的值，继续比较。
 */
public class deleteDuplicate {
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
		{
			return head;
		}
		ListNode p = head;
		ListNode p1 = head;
		int val = head.val;
		head = head.next;
		while (head != null)
		{
			if(head.val == val)
			{
				p1.next = head.next;
				head = head.next;
			}else {
				val = head.val;
				p1 = head;
			}
		}
		return p;
    }
}
