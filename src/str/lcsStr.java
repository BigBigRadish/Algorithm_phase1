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
  /*动态规划思想
      经常会遇到复杂问题不能简单地分解成几个子问题，而会分解出一系列的子问题。简单地采用把大问题分解成子问题，并综合子问题的解导出大问题的解的方法，问题求解耗时会按问题规模呈幂级数增加。

     为了节约重复求相同子问题的时间，引入一个数组，不管它们是否对最终解有用，把所有子问题的解存于该数组    中，这就是动态规划法采用的基本方法

    

最大公共子序列问题                                                                                        在解决最长公共子序列（LCS）问题，即求字符串A，B的公共子序列LCS（注意：LCS不一定连续，但和原始序列的元素顺序有关）中长度最长的公共子序列时，因为最长公共子序列不唯一，但是最长公共子序列长度是一定的，所以先把问题简化，如何求两个序列的最长公共子序列长度？                                    

    我们首先想到的肯定是暴力枚举法。                                                                       先来看看：假设序列A有n 个元素，序列B有 m 个元素，那么A，B分别有2^n，2^m个子序列，如果任意两个子序列一一比较，比较的的子序列高达2^(m+n)对，这还没有算具体的复杂度。

    所以我们可以试试动态规划，把这个问题分解成子问题：求A的前i个元素和B的前j个元素之间的最长公共子序列长度。这时的空间复杂度为o(m+n)。
算法思想 

1、定义dp [i][j]：表示字符串序列A的前i个字符组成的序列Ax和字符串序列B的前j个字符组成的序列By之间的最长                   公共子序列L(i,j )的长度（m ，n分别为Ax和By的长度，i<=m,j<=n）

2、如果Ax [i] =By [j]，那么Ax与By之间的最长公共子序列L( i,j )的最后一项一定是这个元素，

   所以dp [i][j] = dp[i-1][j-1] + 1。

3、如果Ax[i] != By[j]，设LCS（i-1,j-1)是L( i -1, j-1 )的最后一个元素，或者L（i-1,j-1）是空序列，

   则 t!= Ax[i]和t!=By[j]至少有一个不成立。

   （1）    当 LCS（i-1,j-1) != Ax[i] 时，dp[i][j]= dp[i-1][j]；

   （2）    当 LCS（i-1,j-1) != By[j] 时，ap[i][j]= dp[i][j-1]；

   所以dp[i][j]= max ( dp[i-1][j]，dp[i][j-1] )。                         

4、初始值为：dp[0][j] = dp[i][0] = 0.

5、题意要求求出任意一个最长公共子序列，这点要如何实现呢？

   仍然考虑上面的递推式，L（i,j）的最后一个元素LCS( i，j )的来源有三种情况，定义数组flag[MAXN][MAXN]用    以标记来的方向：

  （1) dp[i][j] = dp[i-1][j-1] + 1，对应字符LCS( i-1,j-1)接上LCS( i,j)，flag[i][j] = 1,表示从斜向上      左方来；

  （2) dp[i][j] = dp[i-1][j]，对应字符LCS（i-1,j）接上LCS（i,j），flag[i][j] = 2,表示从上方过来；

  （3) dp[i][j] = dp[i][j-1]，对应字符LCS（I,j-1）接上LCS（i,j），flag[i][j] = 3,表示从左方过来。
   我们只要在计算dp[i][j]时根据来源进行不同的标记，回溯就可以找到一个最长公共子序列。
   */
//动态规划算法求lcs(最长公共子串)之Java代码实现
//求lis，先把lcs串变成顺序的，然后求sortlcs与lcs的最大子字符串 
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
  
                if (c[j] > max[0]) {   //如果是大于那暂时只有一个是最长的,而且要把后面的清0;  
                    max[0] = c[j];  
                    maxIndex[0] = j;  
    
                    for (int k = 1; k < maxLen; k++) {  
                        max[k] = 0;  
                        maxIndex[k] = 0;  
                    }  
                } else if (c[j] == max[0]) {   //有多个是相同长度的子串  
                    for (int k = 1; k < maxLen; k++) {  
                        if (max[k] == 0) {  
                            max[k] = c[j];  
                            maxIndex[k] = j;  
                            break;  //在后面加一个就要退出循环了  
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
            System.out.println("第" + (i + 1) + "个公共子串:" + list.get(i));  
        }  
  
        str1 = new String("adbab1234");  
        str2 = new String("adbbf123s4a");  
        list = getLCSstring(str1.toCharArray(), str2.toCharArray());  
        for (int i = 0; i < list.size(); i++) {  
            System.out.println("第" + (i + 1) + "个公共子串:" + list.get(i));  
        }  
  
    }  
}  

