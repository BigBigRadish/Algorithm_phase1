/**
 * 
 */
package probability_combination;

/**
 * @author Agnostic
 * 海明权值算法，求1的个数
 */
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
