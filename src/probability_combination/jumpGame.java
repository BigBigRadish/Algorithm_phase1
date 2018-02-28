/**
 * 
 */
package probability_combination;

/**
 * ����leetcode����jump game�ļ��ֽⷨ
 * @author Agnostic
 * һ.̰�ķ���ÿһ�α�����ǰ���ߵ����·��
 *  ��.���Կ���bfs�㷨
 *  ����������dp�㷨���������1����dp[i]Ϊ���ﵽA[i]ʱ����ʣ���ٲ���û��-��dp[i+1]=MAX(dp[i],A[i])-1
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
