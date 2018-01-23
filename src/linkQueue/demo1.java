/**
 * 
 */
package linkQueue;

/**
 * @author Agnostic
 *�������������ֱ��ʾ�����Ǹ��������� �ǵ���������洢�������У�
 *��ÿ�����ֻ �洢һ�����֣������������ĺͣ����ҷ��� �͵�����ͷָ�롣
 *�磺���룺2��4��3��5��6��4�������7��0��8 
 */
public class demo1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int val = (l1.val + l2.val) % 10;
		int flag = (l1.val + l2.val) / 10;
		ListNode l3 = new ListNode(val);
		ListNode res = l3;
		while (l1.next != null && l2.next != null)
		{
			l1 = l1.next;
			l2 = l2.next;
			val = (l1.val + l2.val + flag) % 10;
			flag = (l1.val + l2.val + flag) / 10;
			ListNode l4 = new ListNode(val);
			res.next = l4;
			res = l4;
		}
		while (l1.next != null)
		{
			l1 = l1.next;
			val = (l1.val + flag) % 10;
			flag = (l1.val + flag) / 10;
			ListNode l4 = new ListNode(val);
			res.next = l4;
			res = l4;
		}
		while (l2.next != null)
		{
			l2 = l2.next;
			val = (l2.val + flag) % 10;
			flag = (l2.val + flag) / 10;
			ListNode l4 = new ListNode(val);
			res.next = l4;
			res = l4;
		}
		if (flag > 0)
		{
			ListNode l4 = new ListNode(flag);
			res.next = l4;
		}
		return l3;
    }
    public static void main(String [] args){
    	ListNode node=new ListNode(5);
    	ListNode node2=new ListNode(4);
    	demo1 demo =new demo1();
    	ListNode node3=demo.addTwoNumbers(node, node2);
    	while(node3!= null){
    		System.out.print(node3.val);
    		node3=node.next;
    		
    	}; 
    }
}