/**
 * 
 */
package linkQueue;

/**
 * @author Agnostic
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 * 与翻转单链表不同的是，将1->2->3->4->5->NULL转成1->2<-3<-4<-5->NULL是无法从尾节点遍历所有节点的。需要使用另外一种思想。
 * 整体思想就是头插法，比如1->2->3->4把2到4翻转，将结点3插到1和2之间，然后把4再插到1后面。实现翻转。
 * 思想很简单，主要是中间结点不断再变化位置，所以注意保留很多个位置。
 * 需要4个变量：待翻转节点的前一个节点（类似头节点），待插入节点，待插入节点的下一个节点，插完后的链表的最后一个节点。
 */
public class reverseDirect {
    public ListNode reverseDirect1(ListNode head, int m, int n) {
        ListNode res = new ListNode(0);//必须要有空的头结点，因为如果类似1-2，要变成2-1，没办法把2插到1的前面去
		res.next = head;
		ListNode p = res;//待翻转的结点的前一个结点，每次都是插在p的后面
		for (int i = 0; i < m - 1; i++)
		{
			p = p.next;
		}
		ListNode l = p.next.next;//待插入结点
		ListNode q = null;//下一个待插结点
		ListNode d = p.next;//插完后的链表的最后一个结点
		for (int i = 0; i < n - m; i++)
		{
			q = l.next;
			d.next = q;
			l.next = p.next;
			p.next = l;
			l = q;
		}
		return res.next;
    }
}