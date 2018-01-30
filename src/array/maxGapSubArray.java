/**
 * 
 */
package array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Agnostic
 * ����������������hash�㷨��Ͱ�㷨
 * ��Ŀ��������������A[0��N-1]������N����������������
 * �磺1,7,14,9,4,13�������Ϊ4����Ϊ�����1,4,7,9,13,14���������13-9=4
 * �㷨˼�룺
 * �ٶ�N�����������СֵΪmax��min������N�����γ�N-1�����������Сֵ��(max-min)/(N-1)
 * ������N������ȫ���ȷֲ�������ȫ����(max-min)/(N-1)����С��
 * ���N�������Ǿ��ȷֲ�����಻���⣬��������Ȼ����(max-min)/(N-1)
 * ��˽�N�����ü�� �ֳ�N-1�����䣬������ͬһ�����ڵ���������������ࡣ
 * Ȼ��ͳ�ƺ�һ�������Сֵ��ǰһ��������ֵ�Ĳ�ɡ�
 * 1����û���κ�������ĳ���䣬���������Ч��������ͳ�ơ�
 * 2��ʹ��ʱʹ��N�����䣬��Ϊ������ֵΪ10��80���������6�����䣬������Ĵ�СΪ70/6=11.66��ÿ������ֱ�Ϊ��[10,21]�� [22,33]�� [34,44]�� [45,56]�� [57,68]��[69,80]�����ڴ�СΪ12�����䣬�������½�11.66��
 * 3�����ǽ��Ͱ����/Hashӳ���˼�롣
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
		        //Ͱ�ڲ�����ֻ������������һ�����ֵ��һ����Сֵ�������������ϸ��¡�������һ�Ų�Ҫ��  
		        for(int i=0;i<n;i++){  
		        //Ͱ�Ŀ��d = len/ n,Ͱ�ĸ���Ϊ(A[i]- min)/d  Ͱ�ţ�((A[i] - min) * n) / len  
		            int index=(double)(A[i]-minValue)/len*(n-1);//Ͱ��  
		            bocketMax[index]=max(A[i],bocketMax[index]);  
		            bocketMin[index]=min(A[i],bocketMin[index]);  
		        }  
		        //����������������ͬһ��Ͱ�У����Ǻ�һ��Ͱ����Сֵ��ȥǰһ��Ͱ�����ֵ  
		        int res=0,pre=bocketMax[0];  
		        for(int i=1;i<n;i++){  
		            if(bocketMin[i]!=INT_MAX){  
		                res=max(res,bocketMin[i]-pre);  
		                pre=bocketMax[i];//Ͱ��  
		            }  
		        }  
		        return res;  
		    }  
		};  

}
