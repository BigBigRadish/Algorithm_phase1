/**
 * 
 */
package probability_combination;

/**
 * 算法及其描述：男孩儿将一轮一轮地去追求他中意的女子，女子可以选择接受或者拒绝他的追求者。第一轮，每个男孩儿都选择自己名单上排在首位的女 孩儿，并向她表白。此时，一个女孩儿可能面对的情况有三种：没有人跟她表白，只有一个人跟她表白，有不止一个人跟她表白。在第一种情况下，这个女孩儿什么 都不用做，只需要继续等待；在第二种情况下，接受那个人的表白，答应暂时和他做情侣；在第三种情况下，从所有追求者中选择自己最中意的那一位，答应和他暂 时做情侣，并拒绝所有其他追求者。
        第一轮结束后，有些男孩儿已经有女朋友了，有些男孩儿仍然是单身。在第二轮追女行动中，每个单身男孩儿都从所有还没拒绝过他的女孩儿中选出自己 最中意的那一个，并向她表白，不管她现在是否是单身。和第一轮一样，女孩儿们需要从表白者中选择最中意的一位，拒绝其他追求者。注意，如果这个女孩儿已经 有男朋友了，当她遇到了更好的追求者时，她必须拒绝掉现在的男友，投向新的追求者的怀抱。这样，一些单身男孩儿将会得到女友，那些已经有了女友的人也可能 重新变成光棍。在以后的每一轮中，单身男孩儿继续追求列表中的下一个女孩儿，女孩儿则从包括现男友在内的所有追求者中选择最好的一个，并对其他人说不。这 样一轮一轮地进行下去，直到某个时候所有人都不再单身，下一轮将不会有任何新的表白发生，整个过程自动结束。此时的婚姻搭配就一定是稳定的了。
 * @author Agnostic
 * 输入：第一行数据表示 Man(Woman)的数目 n；接下来的数据中，第一个 n*n 的数据 
块表示 Man 的优先列表；另一个 n*n 的数据块表示 Woman 的优先列表) 
5 ———————- (Man(Woman)的数目 n) 
2 1 4 5 3 ————– (第一个男人的优先列表) 
4 2 1 3 5 
2 5 3 4 1 ————– (第三个男人的优先列表) 
1 4 3 2 5 
2 4 1 5 3 
5 1 2 4 3 ————– (第一个女人的优先列表) 
3 2 4 1 5 
2 3 4 5 1 
1 5 4 3 2 
4 2 5 3 1
* 实际意义：学生志愿填报，员工选择单位等“二部”问题
* 有向边算法
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

//          System.out.println("输入第 "+(i+1)+"个男人心中的优先顺序");

            int[] a=new int[num];
            for(int j=0;j<num;j++){
                a[j]=sc.nextInt();
            }
            men[i]=new Man();   //必须先初始化
            men[i].setRank(a);

//          System.out.println(Arrays.toString(men[i].rank));
        }

        for(int i=0;i<num;i++){

//          System.out.println("输入第 "+(i+1)+"个女人心中的优先顺序");

            int[] a=new int[num];
            for(int j=0;j<num;j++){
                a[j]=sc.nextInt();
            }
            women[i]=new Woman();   //必须先初始化
            women[i].setRank(a);

//          System.out.println(Arrays.toString(women[i].rank));
        }



        for(int i=0;i<num;i++){
            if(!men[i].isDate()){  //如果i这个男人没有在约会  这个男生是(i+1)号
                int chase =men[i].getRank()[men[i].getBetter()]; //目前最喜欢chase号女生
                System.out.println((i+1)+"号男生目前最喜欢"+chase+"号女生");
                men[i].setBetter(men[i].getBetter()+1); //成功与否都已经向这个女人请求过了
                System.out.println("追求过的数量变为:"+men[i].getBetter());
               if(!women[chase-1].isDate()){ //如果i心仪的女人没有约会
                   men[i].setDate(true);
                   men[i].setPresent(chase);
                   women[chase-1].setDate(true);
                   women[chase-1].setPresent(i+1);
                   System.out.println((i+1)+"号男生和"+chase+"号女生配成一对");
               }
               else{   //这个女人正在约会 对比现在这个男人和正在约会的男人哪个优先级更高
                   System.out.println("女方有约会对象");
                   int later=0,former=0;
                   for(int r=0;r<num;r++){ //获取排名
                       if(women[chase-1].getRank()[r]==(i+1)){
                           later=r;
//                         System.out.println("later:"+later);
                       }
                       if(women[chase-1].getRank()[r]==women[chase-1].getPresent()){
                           former=r;
//                         System.out.println("former:"+former);
                       }
                   }
                   if(later>former){//你不如对方正在约会的对象
                       System.out.println("former>later 你不如对方正在约会的对象");
                       i=-1;//有人单身狗，必须重新走
                   }else if(later<former){//你比正在约会的强
                       System.out.println("former<later 你比正在约会的强.");
                       System.out.println(women[chase-1].getPresent()+"被分手");

                       men[women[chase-1].getPresent()-1].setDate(false);//前任被分手
                       men[women[chase-1].getPresent()-1].setPresent(100);


                       men[i].setDate(true);
                       men[i].setPresent(chase);

                       women[chase-1].setPresent(i+1);

                       i=-1;//有人单身狗，必须重新走

                   }else{
//                     System.out.println("former=later 有问题");
                   }
               }
            }
        }

        //循环结束，输出结果

        for(int i=0;i<num;i++){
            System.out.print(men[i].getPresent()+" ");
        }

        System.out.println();

    }
}

class People {
    private int id;
    private int better=0;   //追求过几位女生
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

