/**
 * 
 */
package probability_combination;

/**
 * 关于leetcode上面jump game的几种解法
 * @author Agnostic
 * 一.贪心法，每一次遍历当前能走的最大路径
 *  二.可以看做bfs算法
 *  三。可以用dp算法来解决：（1）记dp[i]为：达到A[i]时，还剩多少步都没用-》dp[i+1]=MAX(dp[i],A[i])-1
 ***/
public class jumpGame {
	 public int jump(int[] nums) {  
	        int jump=0;  
	        int maxS=0;  
	        int maxC=0;  
	        for(int i=0;i<nums.length;i++){  
	            if(maxS<i){  
	                jump++;  
	                maxS=maxC;  
	            }  
	            maxC=Math.max(maxC,nums[i]+i);  
	        }  
	          
	       return jump;   
	    } 
	 public static void main(String [] args){
		 int test[]={1,2,3,4,1,2,1,1};
		 int test1;
		 jumpGame jG=new jumpGame();
		 test1=jG.jump(test);
		 System.out.print(test1);
		 
		 
	 }
}
