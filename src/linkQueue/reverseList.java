package linkQueue;
/**
 * @author Agnostic
 * 给定一个单链表，翻转该链表,由于单链表翻转时会丢失节点，所以需要把节点保存起来。
 * 翻转单链表需要存储3个节点，分别是当前节点，当前节点的前面节点，当前节点的后继节点。
 * 注意null时的判断，最后返还时需要把原始节点的尾节点返回。
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
