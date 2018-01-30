/**
 * 
 */
package array;

/**
 * @author Agnostic
 *最大字数组和，贪心算法
 */
public class maxSubarray {
	int []nums={1,2,3,4};
	int maxSubArray(int []nums) {  
	      // write your code here  
	      int sum=nums[0];  
	      int t=sum;  
	      for(int i=1;i<nums.length;i++)  
	      {  
	          if(t<0)t=0;  
	          t=t+nums[i];  
	          if(t>sum)sum=t;  
	            
	      }  
	      return sum;  
	  }                            
}
