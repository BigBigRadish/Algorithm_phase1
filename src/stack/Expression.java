/**
 * 
 */
package stack;

/**
 * @author Agnostic
 *
 */
import java.util.*;  
public class Expression {  
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        Scanner in = new Scanner(System.in);  
        String bds = in.next();//�Ӳ���̨��ȡ���ʽ  
        Calculate cal=new Calculate(bds);//����Calculate�ಢ�����ʽ����  
        System.out.println(cal.count());//��������  
    }  
}  
//ջ��Ԫ����  
class Node {  
    char data;  
    double num;  
    Node next = null;  
    Node prefix = null;  
  
    Node(char data) {  
        this.data = data;  
    }  
    Node(double num) {  
        this.num = num;  
    }  
  
  
    public char getdata() {  
        return data;  
    }  
    public double getnum() {  
        return num;  
    }  
  
  
    public Node getnext() {  
        return next;  
    }  
  
    public void setnext(Node next) {  
        this.next = next;  
    }  
  
    public Node getprefix() {  
        return prefix;  
  
    }  
  
    public void setprefix(Node prefix) {  
        this.prefix = prefix;  
    }  
}  
//ջ������  
class linkedTable {  
    Node listen = null;  
    Node tail = null;  
    Node prefixnode = null;  
    int a = 0; // ��¼ջ����  
  
    linkedTable(Node listen) {  
        this.listen = listen;  
        tail = listen;  
        prefixnode = listen;  
    }  
  
    public Node getlisten() {  
        return listen;  
  
    }  
  
    // ����Ԫ�ص����  
    public void add(Node node) {  
        node.setprefix(prefixnode);  
        node.setnext(null);  
        prefixnode.setnext(node);  
        prefixnode = node;  
        a++;  
    }  
  
    // Ԫ�ص����  
    public Node del() {  
        Node sc = null;  
        Node n = listen;  
        int i = a;  
        if (a == 0) {  
            System.out.print("����----ջ�գ�");  
        } else {  
            while (i > 0) {  
                n = n.getnext();  
                if (i == 1) {  
                    prefixnode = n.getprefix();  
                    n.getprefix().setnext(null);  
                    sc = n;  
                }  
                i--;  
            }  
            a--;  
        }  
        return sc;  
    }  
  
    // ��������б�(�˷������ڲ��ԣ����ܹ���Լ����ʹ��ջʱ����ʹ��)  
    public void loopThrough() {  
        Node n = listen;  
        while (n != null) {  
            System.out.print(n.getdata() + " ");  
            n = n.getnext();  
        }  
        System.out.println();  
    }  
  
    // ��������б�(�˷������ڲ��ԣ����ܹ���Լ����ʹ��ջʱ����ʹ��)  
    public void loopThrough1() {  
    Node n = listen;  
    while (n != null) {  
        System.out.print(n.getnum() + " ");  
        n = n.getnext();  
    }  
    System.out.println();  
}  
  
}  
//���ʽ������  
class Calculate {  
    int end = 0;//�����ж������Ƿ����  
    int n = 0;     //���ڶ�ȡ���ʽ��ָ��ǰʹ���ַ�  
    char[] c;    
    //������Ĺ��캯��  
    Calculate(String bds) {  
        bds=bds+"#";//Ϊ�˱��ڼ����ڱ��ʽ�ַ��������#  
        c = bds.toCharArray();//��String���ַ���ת��Ϊchar������  
    }  
    // �����ַ�ջ  
    Node listen = new Node(' ');//Ϊ�˷���ջ������Ĭ����һ��ջ�ף�ʹ��ջʱ���Ժ���  
    linkedTable countSymbol = new linkedTable(listen);//����ջ��������������  
    // ������ֵջ  
    Node listen1 = new Node('0');  
    linkedTable intValue=new linkedTable(listen1);//����ջ�����������ֵ  
    //��ȡ����ʱ����������  
public char prior(char a,char b){  
        int i=0,j=0;  
        //����һ��char�Ͷ�ά�������ڴ���������ȱ�  
        char[][] pri = { // ��������ȱ�  
                // +    -    *    /    ��         ��         #      ����Ϊ���ʽ��ǰ�����  
        /* + */ { '>', '>', '<', '<', '<', '>', '>' },   
        /* - */ { '>', '>', '<', '<', '<', '>', '>' },  
        /* * */ { '>', '>', '>', '>', '<', '>', '>' },  
        /* / */ { '>', '>', '>', '>', '<', '>', '>' },  
        /*��    */   { '<', '<', '<', '<', '<', '=', ' ' },   
        /* �� */ { '>', '>', '>', '>', ' ', '>', '>' },  
        /* # */ { '<', '<', '<', '<', '<', ' ', 's' }, };  
//����Ϊ�����ջջ���������  
        if(a=='+'){i=0;}  
        if(a=='-'){i=1;}  
        if(a=='*'){i=2;}  
        if(a=='/'){i=3;}  
        if(a=='('){i=4;}  
        if(a==')'){i=5;}  
        if(a=='#'){i=6;}  
        if(b=='+'){j=0;}  
        if(b=='-'){j=1;}  
        if(b=='*'){j=2;}  
        if(b=='/'){j=3;}  
        if(b=='('){j=4;}  
        if(b==')'){j=5;}  
        if(b=='#'){j=6;}      
        return pri[i][j];  
    }  
//������  
public double arithmetic(double a,char c,double b){  
    double result=0;  
    if(c=='+'){result=a+b;}  
    if(c=='-'){result=a-b;}  
    if(c=='*'){result=a*b;}  
    if(c=='/'){result=a/b;}  
    return result;  
      
}  
//��ȡ���ʽ����ֵ����Ϊ���ʽ����char�������ű��ʽ��ͨ���˺���ת��Ϊdouble��  
public double readintValue(char[] c){  
    String s="";//����һ��String����ֵs�������char����ֵ  
    //���ʽ�п��ܴ��ڶ�λ����ֵ������ͨ��һ��ѭ������ת��Ϊһ��double����ֵ  
    while(c[n] != '+' && c[n] != '-' && c[n] != '*' && c[n] != '/'   
            && c[n] != '(' && c[n] != ')' && c[n] != '#'){//�������ָ�����������ô������ֵ  
        s=s+c[n];n++;  
    }  
    double d=Double.valueOf(s);//��String����ֵת��Ϊdouble��  
    return d;  
}  
//����    ***���ʽ��ֵ��������  
public double count(){  
    double d=0;//������ս��  
    double prefix=0,suffix=0;  
    countSymbol.add(new Node('#'));  
    while(end==0)  
    {  
          
        if (c[n] != '+' && c[n] != '-' && c[n] != '*' && c[n] != '/'   
                && c[n] != '(' && c[n] != ')' && c[n] != '#') //����������������ֵ������ֵջ  
        {       intValue.add(new Node(readintValue(c)));}//��ջʱ�����Ϸ��ķ����õ�double����ֵ  
        else{switch(prior(countSymbol.prefixnode.getdata(),c[n])){//�����Ϸ����� ������ջ��������͵�ǰ���ʽ������Ƚ�  
          
        case '<'://ջ��Ԫ�����ȼ���  
            countSymbol.add(new Node(c[n]));//����ǰ���ʽ�������ջ��Ϊ�µ�ջ��  
            n++;                      //n++   ָ����һ���ַ� ����ѭ��  
            break;  
        case'='://�����Ž�����һ�ֽ�          ����'='ʱһ����ջ�������Ϊ'('  ���ʽ��ǰ�����Ϊ')'  
            countSymbol.del();        //����ջ�������'('    ����ѭ��  
            n++;  
            break;  
        case'>':              //��ջ������������ջ  
            suffix=intValue.del().getnum();  //ȡ����ֵջ��ǰջ�� ��Ϊ������  
            prefix=intValue.del().getnum(); //ȡ����ֵջ��ǰջ�� ��Ϊ�ڶ���������   ע�⣺�����һ��һ����ջ��ȥ������ֵ  
            intValue.add(new Node(arithmetic(prefix,countSymbol.del().getdata(),suffix)));  
            //ȡ�������ջջ���������������һ���������㺯���м����������������ֵջ    ����ѭ��  
            break;  
        case's'://������'s'ʱ�������ջ�Ѿ�û�г�'#'�������������������  
            d=intValue.del().getnum();//��ʱ��ֵջ��ֻ��һ����ֵ�������ս��  
            end=1;              //ֹͣѭ��  
        }  
              
        }  
    }  
    return d;    //���������  
      
}  
  
}  