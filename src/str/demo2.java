package str;
/*
 * @author Agnostic
 * 字符串的全排列
 * 给定字符串S[0…N-1]，设计算法，枚举S的 全排列。
 * 递归算法
 * 以字符串1234为例：1 –234 2 –134 3 –214  4 –231
 * */
public class demo2 {
static String str="1234";
static int d= str.length();
char str1[] =str.toCharArray();
 void swap(char a , char b) {  
    char temp;  
    temp = a;  
    a = b;  
    b = temp;  
}  
void Permutation(int from ,int to){//递归算法
if(from==to){
for(int i=0;i<to;i++)
{
	System.out.print(str1[i]);
	}
System.out.print("\n");
return;
}
for(int i=from;i<=to;i++){
	swap(str1[i],str1[from]);
    Permutation(from+1, to);
    swap(str1[i],str1[from]);
}
}
public static void main(String [] args){
demo2 demo=new demo2();
demo.Permutation(0, d-1);
}
}