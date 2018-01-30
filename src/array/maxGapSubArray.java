/**
 * 
 */
package array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Agnostic
 * 求子数组的最大间隔，hash算法，桶算法
 * 题目：给定整数数组A[0…N-1]，求这N个数排序后最大间隔。
 * 如：1,7,14,9,4,13的最大间隔为4。因为排序后：1,4,7,9,13,14，最大间隔是13-9=4
 * 算法思想：
 * 假定N个数的最大最小值为max，min，则这N个数形成N-1个间隔，其最小值是(max-min)/(N-1)
 * 因此如果N个数完全均匀分布，则间距全部是(max-min)/(N-1)且最小；
 * 如果N个数不是均匀分布，间距不均衡，则最大间距必然大于(max-min)/(N-1)
 * 因此将N个数用间距 分成N-1个区间，则落在同一区间内的数不可能有最大间距。
 * 然后统计后一区间的最小值与前一区间的最大值的差即可。
 * 1：若没有任何数落在某区间，则该区间无效，不参与统计。
 * 2：使用时使用N个区间，因为假设最值为10、80，如果适用6个区间，则区间的大小为70/6=11.66，每个区间分别为：[10,21]、 [22,33]、 [34,44]、 [45,56]、 [57,68]、[69,80]，存在大小为12的区间，比理论下界11.66大。
 * 3：这是借鉴桶排序/Hash映射的思想。
 */
public class maxGapSubArray {
	class Gap {  
		public:  
		    int maxGap(vector<int> A, int n) {  
		        int minValue=INT_MAX,maxValue=INT_MIN;  
		        for(int i=0;i<n;i++){  
		            maxValue = max(maxValue, A[i]);  
		            minValue = min(minValue, A[i]);  
		        }  
		        vector<int> bocketMax(n,INT_MIN);  
		        vector<int> bocketMin(n,INT_MAX);  
		        int len=maxValue-minValue;  
		        //桶内不排序，只保留两个数，一个最大值，一个最小值，这两个数不断更新。其他数一概不要。  
		        for(int i=0;i<n;i++){  
		        //桶的宽度d = len/ n,桶的个数为(A[i]- min)/d  桶号：((A[i] - min) * n) / len  
		            int index=(double)(A[i]-minValue)/len*(n-1);//桶号  
		            bocketMax[index]=max(A[i],bocketMax[index]);  
		            bocketMin[index]=min(A[i],bocketMin[index]);  
		        }  
		        //最大间距的两个数不在同一个桶中，而是后一个桶的最小值减去前一个桶的最大值  
		        int res=0,pre=bocketMax[0];  
		        for(int i=1;i<n;i++){  
		            if(bocketMin[i]!=INT_MAX){  
		                res=max(res,bocketMin[i]-pre);  
		                pre=bocketMax[i];//桶号  
		            }  
		        }  
		        return res;  
		    }  
		};  

}
