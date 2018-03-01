/**
 * 
 */
package massiveDataProcess;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Agnostic
 *
 */
class SkipNode<K,V>{//节点类
    K k;
    V v;
    SkipNode<K,V>[] forward; 
    
    @SuppressWarnings("unchecked")
    public SkipNode(K k,V v,int level) {
        this.k = k;
        this.v = v;
        forward = (SkipNode<K,V>[])new SkipNode[level + 1];
        for(int i = 0;i < level;i++) {
            forward[i] = null;
        }
    }
    
    @Override
    public String toString() {
        return "SkipNode [k=" + k + ", v=" + v + ", forward=" + Arrays.toString(forward) + "]";
    }
}
public class skipList<K extends Comparable<? super K>,V> {
    SkipNode<K,V> head;
    int level;
    int size;
    public skipList(){
        head = new SkipNode<K,V>(null,null,0);
        //刚开始只有一层，也就是第0层
        level = 0;
        size = 0;
    }
    /**
     * @Description:随机生成层数
     * @return:int
     */
    private int randomLevel() {//层数可以计算，可以最优化为lnN层，上一层的数量为底层的1/2.
        int lev;
        for(lev = 1;Util.random(2) == 0;lev++);

        return lev;
    }

    public void insert(K k,V v) {
        int newLevel = randomLevel();
        //调整头节点
        if(newLevel > level){
            SkipNode<K,V> tmp = head;
            head = new SkipNode<K,V>(null,null,newLevel);
            for(int i = 0;i < tmp.forward.length;i++){
                head.forward[i] = tmp.forward[i];
            }
            level = newLevel;
        }
        @SuppressWarnings("unchecked")
        SkipNode<K,V>[] update = new SkipNode[level + 1];
        SkipNode<K,V> x = head;
        for(int i = level;i >= 0;i--) {
            while(x.forward[i] != null && x.forward[i].k.compareTo(k) < 0) {
                x = x.forward[i];
            }
            update[i] = x;
        }
        x = x.forward[0];
        if(x != null && x.k != null && x.k.compareTo(k) == 0) {
            x.v = v;
        } else {
            x = new SkipNode<K,V>(k,v,newLevel);
            for(int i = 0;i < newLevel;i++) {
                x.forward[i] = update[i].forward[i];
                update[i].forward[i] = x;
            }
            size++;  
        }
    }


    public V find(K k) {
        SkipNode<K,V> x = head;
        for(int i = level;i >= 0;i--) {
            while(x.forward[i] != null && x.forward[i].k.compareTo(k) < 0) {
                x = x.forward[i];
            }
        }
        x = x.forward[0];
        if(k.compareTo(x.k) == 0) {
            return x.v;
        }
        return null;
    }


    public void delete(K k) {
        @SuppressWarnings("unchecked")
        SkipNode<K,V>[] update = new SkipNode[level + 1];
        SkipNode<K,V> x = head;
        for(int i = level;i >= 0;i--) {
            while(x.forward[i] != null && x.forward[i].k.compareTo(k) < 0) {
                x = x.forward[i];
            }
            update[i] = x;
        }
        x = x.forward[0];
        if(k.compareTo(x.k) == 0) {
            for(int i = 0;i < level;i++) {
                if(update[i].forward[i] != x) {
                    break;
                }
                update[i].forward[i] = x.forward[i];
            }
            x = null;
            while(level > 0 && head.forward[level] == null) {
                level = level - 1;
            }
            size--;
        }
    }
    /**
     * @Description:按层输出(只输出key)
     * @return:void
     */
    public void printKeyByLevel() {
        SkipNode<K,V>  x = head;
        for(int i = level - 1;i >= 0;i--) {
            System.out.print("level-" + i + ":");
            x = head.forward[0];
            String headCurLevelForward = head.forward[i] != null?head.forward[i].k.toString() : "NULL";
            System.out.print(String.format("%5s",headCurLevelForward) + " ");
            while(x != null) {
                if(x.forward.length <= i) {
                    System.out.print(String.format("%5s"," ") + " ");
                } else {
                    if(x.forward[i] == null) {
                        System.out.print(String.format("%5s"," ") + " ");
                    } else {
                        System.out.print(String.format("%5s", x.forward[i].k) + " ");
                    }
                }
                x = x.forward[0];
            }
            System.out.println();
        }
    }
    /**
     * @Description:按节点输出(只输出key)
     * @return:void
     */
    public void printKeyByNode() {
        SkipNode<K,V> x = head;
        while(x != null) {
            System.out.print(String.format("%4s forward-size-%s:",x.k == null?"head":x.k,x.forward.length) + " ");
            for(int i = 0;i < x.forward.length;i++) {
                if(x.forward[i] == null) {
                    System.out.print(String.format("%3s"," ") + " ");
                } else {
                    System.out.print(String.format("%3s",x.forward[i].k,x.forward[i].v) + " ");
                }
            }
            System.out.println();
            x = x.forward[0];
        }
    }
    /**
     * @Description: 随机数生成
     */
    static class Util {
        static Random  random = new Random();
        public  static int random(int n) {
            return Math.abs(random.nextInt()) % n;
        }
    }

    public static void main(String[] args) {
        skipList<Integer,Integer> skipList = new skipList<Integer, Integer>();
        skipList.insert(1, 1);
        skipList.insert(5, 5);
        skipList.insert(17, 17);
        skipList.insert(19, 19);
        skipList.insert(23, 23);
        skipList.insert(26, 26);
        skipList.insert(21, 21);
        System.out.println("printKeyByLevel:");
        skipList.printKeyByLevel();
        System.out.println("printKeyByNode:");
        skipList.printKeyByNode();
    }
}