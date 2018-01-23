package linkQueue;
/**
 * @author Agnostic
 * 构建一个单链表
 * */
class linkNode{
	linkNode next =null;//节点的引用指向下一个节点
	int data;
	public linkNode(int data){
		this.data=data;
	}
}
public class LinkQueue {
	linkNode head =null;//头结点
	  public void addNode(int d) {//增加节点		  
	        linkNode newNode = new linkNode(d);// 实例化一个节点
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
		  
	  }//增加节点
	  /**
	     * 
	     * @param index:删除第index个节点
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
	     * @return 返回节点长度
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
	     * 在不知道头指针的情况下删除指定节点
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
	        System.out.println("删除成功！");
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
