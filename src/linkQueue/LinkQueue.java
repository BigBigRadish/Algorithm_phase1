package linkQueue;
/**
 * @author Agnostic
 * ����һ��������
 * */
class linkNode{
	linkNode next =null;//�ڵ������ָ����һ���ڵ�
	int data;
	public linkNode(int data){
		this.data=data;
	}
}
public class LinkQueue {
	linkNode head =null;//ͷ���
	  public void addNode(int d) {//���ӽڵ�		  
	        linkNode newNode = new linkNode(d);// ʵ����һ���ڵ�
	        if (head == null) {
	            head = newNode;
	            return;
	        }
	        linkNode tmp = head;
	        while (tmp.next != null) {
	            tmp = tmp.next;
	        }
	        tmp.next = newNode;
	    }
	  public boolean hasNext() {
		  linkNode tmp = head;
		  if(tmp.next != null){
			  return true;
		  }
		  else 
			  return false;
		  
	  }//���ӽڵ�
	  /**
	     * 
	     * @param index:ɾ����index���ڵ�
	     * @return
	     */
	    public boolean deleteNode(int index) {
	        if (index < 1 || index > length()) {
	            return false;
	        }
	        if (index == 1) {
	            head = head.next;
	            return true;
	        }
	        int i = 1;
	        linkNode preNode = head;
	        linkNode curNode = preNode.next;
	        while (curNode != null) {
	            if (i == index) {
	                preNode.next = curNode.next;
	                return true;
	            }
	            preNode = curNode;
	            curNode = curNode.next;
	            i++;
	        }
	        return false;
	    }

	    /**
	     * 
	     * @return ���ؽڵ㳤��
	     */
	    public int length() {
	        int length = 0;
	        linkNode tmp = head;
	        while (tmp != null) {
	            length++;
	            tmp = tmp.next;
	        }
	        return length;
	    }

	    /**
	     * �ڲ�֪��ͷָ��������ɾ��ָ���ڵ�
	     * 
	     * @param n
	     * @return
	     */
	    public boolean deleteNode11(linkNode n) {
	        if (n == null || n.next == null)
	            return false;
	        int tmp = n.data;
	        n.data = n.next.data;
	        n.next.data = tmp;
	        n.next = n.next.next;
	        System.out.println("ɾ���ɹ���");
	        return true;
	    }

	    public void printList() {
	        linkNode tmp = head;
	        while (tmp != null) {
	            System.out.println(tmp.data);
	            tmp = tmp.next;
	        }
	    }
}
