/**
 * 
 */
package probability_combination;

/**
 * �㷨�����������к�����һ��һ�ֵ�ȥ׷���������Ů�ӣ�Ů�ӿ���ѡ����ܻ��߾ܾ�����׷���ߡ���һ�֣�ÿ���к�����ѡ���Լ�������������λ��Ů ��������������ס���ʱ��һ��Ů����������Ե���������֣�û���˸�����ף�ֻ��һ���˸�����ף��в�ֹһ���˸�����ס��ڵ�һ������£����Ů����ʲô ����������ֻ��Ҫ�����ȴ����ڵڶ�������£������Ǹ��˵ı�ף���Ӧ��ʱ���������£��ڵ���������£�������׷������ѡ���Լ����������һλ����Ӧ������ ʱ�����£����ܾ���������׷���ߡ�
        ��һ�ֽ�������Щ�к����Ѿ���Ů�����ˣ���Щ�к�����Ȼ�ǵ����ڵڶ���׷Ů�ж��У�ÿ�������к����������л�û�ܾ�������Ů������ѡ���Լ� ���������һ������������ף������������Ƿ��ǵ����͵�һ��һ����Ů��������Ҫ�ӱ������ѡ���������һλ���ܾ�����׷���ߡ�ע�⣬������Ů�����Ѿ� ���������ˣ����������˸��õ�׷����ʱ��������ܾ������ڵ����ѣ�Ͷ���µ�׷���ߵĻ�����������һЩ�����к�������õ�Ů�ѣ���Щ�Ѿ�����Ů�ѵ���Ҳ���� ���±�ɹ�������Ժ��ÿһ���У������к�������׷���б��е���һ��Ů������Ů������Ӱ������������ڵ�����׷������ѡ����õ�һ��������������˵������ ��һ��һ�ֵؽ�����ȥ��ֱ��ĳ��ʱ�������˶����ٵ�����һ�ֽ��������κ��µı�׷��������������Զ���������ʱ�Ļ��������һ�����ȶ����ˡ�
 * @author Agnostic
 * ���룺��һ�����ݱ�ʾ Man(Woman)����Ŀ n���������������У���һ�� n*n ������ 
���ʾ Man �������б���һ�� n*n �����ݿ��ʾ Woman �������б�) 
5 ��������������- (Man(Woman)����Ŀ n) 
2 1 4 5 3 ���������C (��һ�����˵������б�) 
4 2 1 3 5 
2 5 3 4 1 ���������C (���������˵������б�) 
1 4 3 2 5 
2 4 1 5 3 
5 1 2 4 3 ���������C (��һ��Ů�˵������б�) 
3 2 4 1 5 
2 3 4 5 1 
1 5 4 3 2 
4 2 5 3 1
* ʵ�����壺ѧ��־Ը���Ա��ѡ��λ�ȡ�����������
* ������㷨
 */
import java.util.Arrays;
import java.util.Scanner;

public class galeShapley {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Woman women[] = new Woman[num];
        Man men[]= new Man[num];

//      System.out.println("num= "+num);

        for(int i=0;i<num;i++){

//          System.out.println("����� "+(i+1)+"���������е�����˳��");

            int[] a=new int[num];
            for(int j=0;j<num;j++){
                a[j]=sc.nextInt();
            }
            men[i]=new Man();   //�����ȳ�ʼ��
            men[i].setRank(a);

//          System.out.println(Arrays.toString(men[i].rank));
        }

        for(int i=0;i<num;i++){

//          System.out.println("����� "+(i+1)+"��Ů�����е�����˳��");

            int[] a=new int[num];
            for(int j=0;j<num;j++){
                a[j]=sc.nextInt();
            }
            women[i]=new Woman();   //�����ȳ�ʼ��
            women[i].setRank(a);

//          System.out.println(Arrays.toString(women[i].rank));
        }



        for(int i=0;i<num;i++){
            if(!men[i].isDate()){  //���i�������û����Լ��  ���������(i+1)��
                int chase =men[i].getRank()[men[i].getBetter()]; //Ŀǰ��ϲ��chase��Ů��
                System.out.println((i+1)+"������Ŀǰ��ϲ��"+chase+"��Ů��");
                men[i].setBetter(men[i].getBetter()+1); //�ɹ�����Ѿ������Ů���������
                System.out.println("׷�����������Ϊ:"+men[i].getBetter());
               if(!women[chase-1].isDate()){ //���i���ǵ�Ů��û��Լ��
                   men[i].setDate(true);
                   men[i].setPresent(chase);
                   women[chase-1].setDate(true);
                   women[chase-1].setPresent(i+1);
                   System.out.println((i+1)+"��������"+chase+"��Ů�����һ��");
               }
               else{   //���Ů������Լ�� �Ա�����������˺�����Լ��������ĸ����ȼ�����
                   System.out.println("Ů����Լ�����");
                   int later=0,former=0;
                   for(int r=0;r<num;r++){ //��ȡ����
                       if(women[chase-1].getRank()[r]==(i+1)){
                           later=r;
//                         System.out.println("later:"+later);
                       }
                       if(women[chase-1].getRank()[r]==women[chase-1].getPresent()){
                           former=r;
//                         System.out.println("former:"+former);
                       }
                   }
                   if(later>former){//�㲻��Է�����Լ��Ķ���
                       System.out.println("former>later �㲻��Է�����Լ��Ķ���");
                       i=-1;//���˵���������������
                   }else if(later<former){//�������Լ���ǿ
                       System.out.println("former<later �������Լ���ǿ.");
                       System.out.println(women[chase-1].getPresent()+"������");

                       men[women[chase-1].getPresent()-1].setDate(false);//ǰ�α�����
                       men[women[chase-1].getPresent()-1].setPresent(100);


                       men[i].setDate(true);
                       men[i].setPresent(chase);

                       women[chase-1].setPresent(i+1);

                       i=-1;//���˵���������������

                   }else{
//                     System.out.println("former=later ������");
                   }
               }
            }
        }

        //ѭ��������������

        for(int i=0;i<num;i++){
            System.out.print(men[i].getPresent()+" ");
        }

        System.out.println();

    }
}

class People {
    private int id;
    private int better=0;   //׷�����λŮ��
    private int[] rank;
    private boolean date=false;
    private int present=100;
    private int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getBetter() {
        return better;
    }
    public void setBetter(int better) {
        this.better = better;
    }
    public int[] getRank() {
        return rank;
    }
    public void setRank(int[] rank) {
        this.rank = rank;
    }
    public boolean isDate() {
        return date;
    }
    public void setDate(boolean date) {
        this.date = date;
    }
    public int getPresent() {
        return present;
    }
    public void setPresent(int present) {
        this.present = present;
    }


}

class Woman extends People{

}

class Man extends People{

}

