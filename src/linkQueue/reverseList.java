package linkQueue;
/**
 * @author Agnostic
 * ����һ����������ת������,���ڵ�����תʱ�ᶪʧ�ڵ㣬������Ҫ�ѽڵ㱣��������
 * ��ת��������Ҫ�洢3���ڵ㣬�ֱ��ǵ�ǰ�ڵ㣬��ǰ�ڵ��ǰ��ڵ㣬��ǰ�ڵ�ĺ�̽ڵ㡣
 * ע��nullʱ���жϣ���󷵻�ʱ��Ҫ��ԭʼ�ڵ��β�ڵ㷵�ء�
 * */
public class reverseList
{
	public ListNode reverseList(ListNode head)
	{
		ListNode reversedHead = null;

		ListNode currentNode = head;
		ListNode prevNode = null;
		ListNode nextNode = null;
		while (currentNode != null)
		{
			nextNode = currentNode.next;
			if (nextNode == null)
			{
				reversedHead = currentNode;
			}
			currentNode.next = prevNode;
			prevNode = currentNode;
			currentNode = nextNode;
		}
		return reversedHead;
	}
}
