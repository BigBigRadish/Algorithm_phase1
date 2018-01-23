package linkQueue;
/**
 * @author Agnostic
 * ����һ�������һ��ֵx���������ֳ������֣�ʹ�û��ֺ�С��x�Ľ����ǰ
 * ���ڵ���x�Ľ���ں�������������Ҫ����ԭ�����еĳ���˳��(Leetcode 86)��
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 * ѡ��һ��pivot��Ȼ�����зֳ����ߣ�һ�߱�pivotС��һ�߱�pivot��Ȼ�󲻶ϵݹ顣
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
