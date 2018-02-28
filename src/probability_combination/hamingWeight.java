/**
 * 
 */
package probability_combination;

/**
 * @author Agnostic
 * 海明权值算法，求1的个数
 * 思想：错位分段相加，然后递归合并的过程。

0x55555555 ->0101 0101 0101 0101 0101 0101 0101 0101

0x33333333 ->0011 0011 0011 0011 0011 0011 0011 0011

0x0f0f0f0f    ->0000 1111 0000 1111 0000 1111 0000 1111

0x0000ffff    ->0000 0000 0000 0000 1111 1111 1111 1111

因此可以看出：

整个数按照上述的周期被分成了n段，

每段里面的前半截都被清零，

后半截保留了数据。

不同在于这些数分段的长度是2倍增长的。于是我们可以姑且命名它们为“分段截取常数”
 */
/*其他算法
 * .除以2，逐个数，遍历。

复制代码
 1 class HammingWeight{
 2 public:
 3     int HammingWeight(uint32_t n){
 4         int cnt=0;
 5         while(n!=0)
 6         {
 7             if(n%2==1) //满足尾数为1
 8                 cnt++;
 9             n/=2;//除以2，右移一位
10         }
11 
12         return cnt;
13     }
14 
15 };
复制代码
 

2.位操作：

复制代码
 1 class HammingWeight{
 2 public:
 3     int HammingWeight(uint32_t n){
 4         int cnt=0;
 5         while(n!=0)
 6         {
 7             cnt+=n&1;//尾数按位与1
 8             n>>=1;//右移一位
 9         }
10         return cnt;
11     }
12 }
复制代码
 

因此，对于任何一个整数n（对应的二进制数有位），它都要进行次判断。可以说，算法效率比较低，每一位都进行了判断。

 

3.n&=n-1

n&=n-1, 只与二进制中1的位数相关的算法

考虑每次找到最低位开始遇到的第一个1，计数，再把它清零，清零的位运算操作是&0，

但是在有1的这一位&0的操作，要同时不影响未统计过的位数和已经统计过的位数，因此有 n&=n-1这样的方法。

该操作对比当前操作位高的位没有影响，对低位则完全清零。

比如：

6（110），

第一次 110&101=100，这次操作成功的把从低位起第一个1消掉了，同时计数器加1。

第二次100&011=000，同理又统计了高位的一个1，此时n已变为0，不需要再继续了，于是110中有2个1。

复制代码
 1 class HammingWeight{
 2 public:
 3     int HammingWeight(uint32_t n){
 4         int cnt=0;
 5         whilie(n!=0)
 6         {
 7             n&=n-1;
 8             cnt++;
 9         }
10         return cnt;
11     }
12 }*/
public class hamingWeight {
	 int HammingWeight(int n){
	        n=(n&0x55555555)+((n>>1)&0x55555555);
	        n=(n&0x33333333)+((n>>2)&0x33333333);
	        n=(n&0x0f0f0f0f)+((n>>4)&0x0f0f0f0f);
	        n=(n&0x00ff00ff)+((n>>8)&0x00ff00ff);
	        n=(n&0x0000ffff)+((n>>16)&0x0000ffff);
	        return n;
	    }
	 public static void main(String [] args){
		 int test;
		 hamingWeight haw=new hamingWeight();
		 test=haw.HammingWeight(100);
		 System.out.print(test);
		 
		 
	 }
}
