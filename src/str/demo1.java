package str;
/**
 * 
 * @author Agnostic
 * 字符串循环左移
 *  给定一个字符串S[0…N-1]，要求把S的前k 个字符移动到S的尾部，
 *  如把字符串“abcdef” 前面的2个字符‘a’、‘b’移动到字符串的尾 部，
 *  得到新字符串“cdefab”：即字符串循环 左移k。 
 * */
/* 算法思想
 * (X’Y’)’=YX  
 * 如：abcdef  X=ab X’=ba  Y=cdef Y’=fedc  (X’Y’)’=(bafedc)’=cdefab 
 * */
public class demo1 {
String reverseStr(String s,int from ,int to){//对字符进行倒置的算法，from表示开始的位置，to表示结束的位置
	char str[] =s.toCharArray();
	while(from<to){
	char str1= str[from];
	str[from++]=str[to];
	str[to--]=str1;
	}
    s= String.valueOf(str);//字符数组再转换成字符串
    return s;

}
String leftRotateStr(String s,int n ,int m){
	s=reverseStr(s, 0, n-1);
	s=reverseStr(s, n, m-1);
	s=reverseStr(s, 0, m-1);
	return s;
}
public static void main(String []args ){
	String str="123456";
	int d=str.length();
	demo1 demo= new demo1();
	str =demo.leftRotateStr( str,2 ,d);
	System.out.print(str);
}

}
