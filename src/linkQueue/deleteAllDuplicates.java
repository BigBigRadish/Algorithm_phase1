/**
 * 
 */
package linkQueue;

/**
 * @author Agnostic
 * 给定排序的链表，若发现重复元素，则重复元素全部删除。（Leetcode 82）
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * 碰到相同的就跳过即可。
 */
public class deleteAllDuplicates {
	public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
		{
			return head;
		}
		ListNode res = new ListNode(0);
		res.next = head;
		ListNode p = res;//最后一个不重复的结点
		while (head != null)
		{
			if (head.next == null || head.val != head.next.val)
			{
				p = head;
				head = head.next;
			}
			else
			{
				while (head.next != null && head.val == head.next.val)
				{
					head = head.next;
				}
				head = head.next;
				p.next = head;
			}
			
		}
		return res.next;
    }
}
