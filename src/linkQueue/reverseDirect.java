/**
 * 
 */
package linkQueue;

/**
 * @author Agnostic
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 * �뷭ת������ͬ���ǣ���1->2->3->4->5->NULLת��1->2<-3<-4<-5->NULL���޷���β�ڵ�������нڵ�ġ���Ҫʹ������һ��˼�롣
 * ����˼�����ͷ�巨������1->2->3->4��2��4��ת�������3�嵽1��2֮�䣬Ȼ���4�ٲ嵽1���档ʵ�ַ�ת��
 * ˼��ܼ򵥣���Ҫ���м��㲻���ٱ仯λ�ã�����ע�Ᵽ���ܶ��λ�á�
 * ��Ҫ4������������ת�ڵ��ǰһ���ڵ㣨����ͷ�ڵ㣩��������ڵ㣬������ڵ����һ���ڵ㣬��������������һ���ڵ㡣
 */
public class reverseDirect {
    public ListNode reverseDirect1(ListNode head, int m, int n) {
        ListNode res = new ListNode(0);//����Ҫ�пյ�ͷ��㣬��Ϊ�������1-2��Ҫ���2-1��û�취��2�嵽1��ǰ��ȥ
		res.next = head;
		ListNode p = res;//����ת�Ľ���ǰһ����㣬ÿ�ζ��ǲ���p�ĺ���
		for (int i = 0; i < m - 1; i++)
		{
			p = p.next;
		}
		ListNode l = p.next.next;//��������
		ListNode q = null;//��һ��������
		ListNode d = p.next;//��������������һ�����
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