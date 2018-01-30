/**
 * 
 */
package array;

/**
 * @author Agnostic
 * Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.

题目解析：
找到第一个不存在的最小正整数。
 *循环不变式思想
 *循环不变式（loop invariants）不只是一种计算机科学的思想，准确地说是一种数学思想。在数学上阐述了通过循环（迭代、递归）去计算一个累计的目标值的正确性。

比如插入排序，每次循环从数组A中取出第j个元素插入有序区A[1 .. j-1]，然后递增j。这样A[1 .. j-1]的有序性始终得到保持，这就是所谓的“循环不变”了。

循环不变式主体是不变式，也就是一种描述规则的表达式。其过程分三个部分：初始，保持，终止。
　　1、初始：保证在初始的时候不变式为真。
　　2、保持：保证在每次循环开始和结束的时候不变式都为真。
　　3、终止：如果程序可以在某种条件下终止，那么在终止的时候，就可以得到自己想要的正确结果。 
　　在这三个部分中，前两个是条件，最有一个是结论。

利用循环不变式(loop invariant)来证明循环的正确性与用数学归纳法(induction)证明数学等式的相同点在于：

都需要验证初值，或初始状态是否满足条件。
之后再证明在归纳或递推的过程中仍然满足这种条件。（这个条件在数学归纳中叫做递推关系，在循环中就是循环不变式(loop invariant)）。

循环不变式(loop invariant)与数学归纳法(induction)的区别在于：

数学归纳可能是无限的，是无限地腿的，但循环不变式所要证明的循环是要结束并给出正确结果的。
 */
public class firstMissingPositive {  
		    int firstMissingPositive(int A[], int n) {  
		        for(int i = 0;i < n;){  
		            if(A[i]>0 && A[i]<=n && A[i] != A[A[i]-1]){ //在范围内，且不在正确的位置上要将A[i]调整到正确的位置  
		                int index = A[i];   //不能简单的交换，否则A[A[i]-1]就不是原来的位置了！  
		                int temp = index;  
		                A[i] = A[index-1];  
		                A[index-1] = temp;  
		            }else   //但是被换到A[i]的新值需要重新检测，所以当不满足条件的时候才增加i的值  
		                ++i;  
		        }  
		        for(int i = 0;i < n;i++)  
		            if(A[i]!=i+1)  
		                return i+1;  
		        return n+1;  
		    }  
		} 

