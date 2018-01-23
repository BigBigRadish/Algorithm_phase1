/**
 * 
 */
package linkQueue;

/**
 * @author Agnostic
 * �������������ɾ���ظ�Ԫ�أ�ֻ�����ظ�Ԫ�ص�һ�γ��ֵĽ�㣨Leetcode 83����
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * �������ź���ģ�����һ����ͬ��ֵ�ͱ���������Ȼ��Ƚ���һ������ֵ�ǲ��Ǻ�����ͬ��
 * �����ͬ��ɾ�������㣬�����ͬ��ı䱣��������ֵ�������Ƚϡ�
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
