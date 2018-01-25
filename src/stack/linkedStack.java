/**
 * 
 */
package stack;

/**
 * @author Agnostic
 *Õ»µÄÊµÏÖ
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

