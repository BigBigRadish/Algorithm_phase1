/**
 * 
 */
package array;

/**
 * @author Agnostic
 *题目：长度为N的数组A中子数组和最接近0的子数组？
 *数组下标从 0 到 i 中
 *数组下标从 i 到 j 中 
 *（其中 i，j均小于数组长度）
 *对于第一种情况，只需要求出数组A从0带A.length所有前i项和，然后找出最小的。
 *对于第二种情况，先求出 1 中所有前i项和，然后从小到大排序，最后将排序后的前i项和两两相减，取差值最小的
 *最后取 1 和2 两种情况中最小者返回即可
 */
public class zeroSubArray {
	 public static void main(String[] args) {
	        int[] array = { 0,-1,-2,3,4,5,-7,-8 };
	        // 1.s[0...i] 子数组和最接近于0
	        int[] s1 = f1(array);
	        // 2.s[i...j] 子数组和最接近于0
	        int res = f2(s1);
	        System.out.println("\n结果：\n" + res);
	    }

	    private static int f2(int[] s1) {
	        int min = s1[0];
	        for (int i = 1; i < s1.length; i++) {

	            int s = s1[i] - s1[i - 1];
	            if (Math.abs(min) > Math.abs(s)) {
	                min = s;
	            }
	        }
	        return min;
	    }

	    private static int[] f1(int[] array) {
	        int[] s = new int[array.length];
	        s[0] = array[0];
	        for (int i = 1; i < array.length; i++) {
	            s[i] = s[i - 1] + array[i];
	        }
	        System.out.println("排序前：");
	        for (int i = 0; i < s.length; i++) {
	            System.out.print(s[i] + " ");
	        }
	        return order(s);
	    }

	    // 排序
	    private static int[] order(int[] s) {
	        for (int i = 0; i < s.length; i++) {
	            for (int j = i; j < s.length; j++) {
	                if (s[i] > s[j]) {
	                    int a = s[i];
	                    s[i] = s[j];
	                    s[j] = a;
	                }
	            }
	        }
	        System.out.println("\n排序后：");
	        for (int i = 0; i < s.length; i++) {
	            System.out.print(s[i] + " ");
	        }
	        System.out.println();
	        return s;
	    }
}
