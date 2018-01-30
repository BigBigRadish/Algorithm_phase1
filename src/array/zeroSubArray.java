/**
 * 
 */
package array;

/**
 * @author Agnostic
 *��Ŀ������ΪN������A�����������ӽ�0�������飿
 *�����±�� 0 �� i ��
 *�����±�� i �� j �� 
 *������ i��j��С�����鳤�ȣ�
 *���ڵ�һ�������ֻ��Ҫ�������A��0��A.length����ǰi��ͣ�Ȼ���ҳ���С�ġ�
 *���ڵڶ������������� 1 ������ǰi��ͣ�Ȼ���С�����������������ǰi������������ȡ��ֵ��С��
 *���ȡ 1 ��2 �����������С�߷��ؼ���
 */
public class zeroSubArray {
	 public static void main(String[] args) {
	        int[] array = { 0,-1,-2,3,4,5,-7,-8 };
	        // 1.s[0...i] ���������ӽ���0
	        int[] s1 = f1(array);
	        // 2.s[i...j] ���������ӽ���0
	        int res = f2(s1);
	        System.out.println("\n�����\n" + res);
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
	        System.out.println("����ǰ��");
	        for (int i = 0; i < s.length; i++) {
	            System.out.print(s[i] + " ");
	        }
	        return order(s);
	    }

	    // ����
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
	        System.out.println("\n�����");
	        for (int i = 0; i < s.length; i++) {
	            System.out.print(s[i] + " ");
	        }
	        System.out.println();
	        return s;
	    }
}
