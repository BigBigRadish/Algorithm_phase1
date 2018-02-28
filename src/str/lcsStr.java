/**
 * 
 */
package str;

/**
 * @author Agnostic
 *
 */
import java.util.ArrayList;  
import java.util.List;  
  /*��̬�滮˼��
      �����������������ⲻ�ܼ򵥵طֽ�ɼ��������⣬����ֽ��һϵ�е������⡣�򵥵ز��ðѴ�����ֽ�������⣬���ۺ�������Ľ⵼��������Ľ�ķ�������������ʱ�ᰴ�����ģ���ݼ������ӡ�

     Ϊ�˽�Լ�ظ�����ͬ�������ʱ�䣬����һ�����飬���������Ƿ�����ս����ã�������������Ľ���ڸ�����    �У�����Ƕ�̬�滮�����õĻ�������

    

��󹫹�����������                                                                                        �ڽ������������У�LCS�����⣬�����ַ���A��B�Ĺ���������LCS��ע�⣺LCS��һ������������ԭʼ���е�Ԫ��˳���йأ��г�����Ĺ���������ʱ����Ϊ����������в�Ψһ����������������г�����һ���ģ������Ȱ�����򻯣�������������е�����������г��ȣ�                                    

    ���������뵽�Ŀ϶��Ǳ���ö�ٷ���                                                                       ������������������A��n ��Ԫ�أ�����B�� m ��Ԫ�أ���ôA��B�ֱ���2^n��2^m�������У������������������һһ�Ƚϣ��Ƚϵĵ������иߴ�2^(m+n)�ԣ��⻹û�������ĸ��Ӷȡ�

    �������ǿ������Զ�̬�滮�����������ֽ�������⣺��A��ǰi��Ԫ�غ�B��ǰj��Ԫ��֮�������������г��ȡ���ʱ�Ŀռ临�Ӷ�Ϊo(m+n)��
�㷨˼�� 

1������dp [i][j]����ʾ�ַ�������A��ǰi���ַ���ɵ�����Ax���ַ�������B��ǰj���ַ���ɵ�����By֮����                   ����������L(i,j )�ĳ��ȣ�m ��n�ֱ�ΪAx��By�ĳ��ȣ�i<=m,j<=n��

2�����Ax [i] =By [j]����ôAx��By֮��������������L( i,j )�����һ��һ�������Ԫ�أ�

   ����dp [i][j] = dp[i-1][j-1] + 1��

3�����Ax[i] != By[j]����LCS��i-1,j-1)��L( i -1, j-1 )�����һ��Ԫ�أ�����L��i-1,j-1���ǿ����У�

   �� t!= Ax[i]��t!=By[j]������һ����������

   ��1��    �� LCS��i-1,j-1) != Ax[i] ʱ��dp[i][j]= dp[i-1][j]��

   ��2��    �� LCS��i-1,j-1) != By[j] ʱ��ap[i][j]= dp[i][j-1]��

   ����dp[i][j]= max ( dp[i-1][j]��dp[i][j-1] )��                         

4����ʼֵΪ��dp[0][j] = dp[i][0] = 0.

5������Ҫ���������һ������������У����Ҫ���ʵ���أ�

   ��Ȼ��������ĵ���ʽ��L��i,j�������һ��Ԫ��LCS( i��j )����Դ�������������������flag[MAXN][MAXN]��    �Ա�����ķ���

  ��1) dp[i][j] = dp[i-1][j-1] + 1����Ӧ�ַ�LCS( i-1,j-1)����LCS( i,j)��flag[i][j] = 1,��ʾ��б����      ������

  ��2) dp[i][j] = dp[i-1][j]����Ӧ�ַ�LCS��i-1,j������LCS��i,j����flag[i][j] = 2,��ʾ���Ϸ�������

  ��3) dp[i][j] = dp[i][j-1]����Ӧ�ַ�LCS��I,j-1������LCS��i,j����flag[i][j] = 3,��ʾ���󷽹�����
   ����ֻҪ�ڼ���dp[i][j]ʱ������Դ���в�ͬ�ı�ǣ����ݾͿ����ҵ�һ������������С�
   */
//��̬�滮�㷨��lcs(������Ӵ�)֮Java����ʵ��
//��lis���Ȱ�lcs�����˳��ģ�Ȼ����sortlcs��lcs��������ַ��� 
public class lcsStr {  

    public static List<String> getLCSstring(char[] str1, char[] str2) {  
        int i, j;  
        int len1, len2;  
        len1 = str1.length;  
        len2 = str2.length;  
        int maxLen = len1 > len2 ? len1 : len2;  
        int[] max = new int[maxLen];  
        int[] maxIndex = new int[maxLen];  
        int[] c = new int[maxLen];  
        List<String> list = new ArrayList<>();  
  
        for (i = 0; i < len2; i++) {  
            for (j = len1 - 1; j >= 0; j--) {  
                if (str2[i] == str1[j]) {  
                    if ((i == 0) || (j == 0))  
                        c[j] = 1;  
                    else  
                        c[j] = c[j - 1] + 1;  
                } else {  
                    c[j] = 0;  
                }  
  
                if (c[j] > max[0]) {   //����Ǵ�������ʱֻ��һ�������,����Ҫ�Ѻ������0;  
                    max[0] = c[j];  
                    maxIndex[0] = j;  
    
                    for (int k = 1; k < maxLen; k++) {  
                        max[k] = 0;  
                        maxIndex[k] = 0;  
                    }  
                } else if (c[j] == max[0]) {   //�ж������ͬ���ȵ��Ӵ�  
                    for (int k = 1; k < maxLen; k++) {  
                        if (max[k] == 0) {  
                            max[k] = c[j];  
                            maxIndex[k] = j;  
                            break;  //�ں����һ����Ҫ�˳�ѭ����  
                        }  
  
                    }  
                }  
            }  
        }  
  
        for (j = 0; j < maxLen; j++) {  
            if (max[j] > 0) {  
  
                StringBuffer sb = new StringBuffer();  
                for (i = maxIndex[j] - max[j] + 1; i <= maxIndex[j]; i++) {  
                    sb.append(str1[i]);  
                }  
                String lcs = sb.toString();  
                list.add(lcs);  
            }  
        }  
        return list;  
    }  
    
    public static void main(String[] args) {  
  
        String str1 = new String("adbba12345");  
        String str2 = new String("adbbf1234sa");  
        List<String> list = getLCSstring(str1.toCharArray(), str2.toCharArray());  
        for (int i = 0; i < list.size(); i++) {  
            System.out.println("��" + (i + 1) + "�������Ӵ�:" + list.get(i));  
        }  
  
        str1 = new String("adbab1234");  
        str2 = new String("adbbf123s4a");  
        list = getLCSstring(str1.toCharArray(), str2.toCharArray());  
        for (int i = 0; i < list.size(); i++) {  
            System.out.println("��" + (i + 1) + "�������Ӵ�:" + list.get(i));  
        }  
  
    }  
}  

