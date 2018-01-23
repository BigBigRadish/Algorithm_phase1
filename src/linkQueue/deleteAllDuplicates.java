/**
 * 
 */
package linkQueue;

/**
 * @author Agnostic
 * ��������������������ظ�Ԫ�أ����ظ�Ԫ��ȫ��ɾ������Leetcode 82��
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * ������ͬ�ľ��������ɡ�
 */
public class deleteAllDuplicates {
	public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
		{
			return head;
		}
		ListNode res = new ListNode(0);
		res.next = head;
		ListNode p = res;//���һ�����ظ��Ľ��
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
