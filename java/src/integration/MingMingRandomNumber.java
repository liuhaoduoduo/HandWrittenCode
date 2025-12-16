/**
 * 明明的随机数：对一组可能无序且可能含有重复数字的随机数数组进行去重，去重输出不重复的数有多少个并将去重后数根据由小到大排列输出。
 * 如果将该题视为一个算法题，那就需要完全手动的去实现去重和排序两套算法。略显复杂，绝对不是数分钟或十几分钟能完成的题目，一般没见过在面试中这样考察的。
 * 如果作为综合应用题，那就直接使用java中提供即满足去重又能自动排序的集合类即可完成。
 * 在java体系中能满足去重和排序的集合类必定想到用TreeSet。
 * 
 */
package integration;

import java.util.TreeSet;
import java.util.Iterator;

public class MingMingRandomNumber {

    public static void main(String[] args){
        //待处理的数组
        int[] arr = new int[]{23, 56, 78, 90, 12, 34, 45, 67, 89, 23, 56, 78, 101, 112, 134};
        //做去重和排序的集合类
        TreeSet<Integer> set = new TreeSet<>();
        //遍历数将其放到集合类
        for(int i = 0;i<arr.length;i++){
            set.add(arr[i]);
        }
        //输出一共有多少个不重复的数
        System.out.println("不重复的数一共有："+set.size()+"个，他们分别是：");
        //用迭代器遍历集合类中的元素
        Iterator<Integer> iterator=set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            //美化输出，只有当有下一个元素时在补空格
            if (iterator.hasNext()) {
                System.out.print(" ");
            }
        }
    }
}
