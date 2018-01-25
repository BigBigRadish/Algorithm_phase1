/**
 * 
 */
package stack;

/**
 * @author Agnostic
 *这是一个简单的堆栈，用java代码写的，利用泛型控制类型，有点递归的感觉吧，end()方法相当于末端哨兵，当读取到末端时，哨兵报警，停止读取。

类的item相当于头，next相当于尾部。pop()方法负责拉出数据，push()方法负责推入数据。

其实linkedList本身已经具备了创建堆栈所必须的方法，而stack可以通过两个泛型的类Stack可以通过两个泛型的类stack和linkedlist的组合来创建。
 */
	import javax.naming.NameNotFoundException;
	import java.awt.geom.Line2D;
	import java.util.ArrayList;
	import java.util.List;
	public class linkedStack<T> {
	    private static class Node<U>{
	        U item;
	        Node<U> next;
	        Node(){item=null;next=null;}

	        Node(U item,Node<U> next){
	            this.item = item;
	            this.next = next;
	        }
	        boolean end(){return item==null&&next==null;}
	    }
	    private Node<T> top = new Node<T>();

	    public void push(T item){
	        top = new Node<T>(item,top);
	    }
	    public T pop(){
	        T result = top.item;
	        if (!top.end()) {
	           top= top.next;

	        }
	        return result;
	    }

	    public static void main(String[] args) {

	        List l = new ArrayList();
	        linkedStack<String> lss = new linkedStack<String>();
	        for (String s:"a b c d e".split(" ")
	             ) {
	            lss.push(s);

	        }
	        String s;
	        while ((s=lss.pop())!=null){
	            System.out.println(s);
	        }
	    }

	}

