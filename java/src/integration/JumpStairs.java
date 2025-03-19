/**
 * 青蛙跳台阶问题。一只青蛙，可以一次跳一级台阶，也可以一次跳两级台阶。问这只青蛙如果想跳上N级台阶一共有多少种跳法。
 * 这其实是一个斐波那契额数列问题。为什么这么说呢，请看下面的解释。
 * 假设现在有一只青蛙，如上题中所说，一次可以跳一级或两级台阶。
 * 当台阶只有一级时，青蛙只能选择一次跳一级台阶。所以只有一种跳法
 * 当台阶有两级时，青蛙可以选择一次跳一级跳两次，或一次跳两级跳一次。所以有两种跳法
 * 当台阶有三级时，青蛙可以选择一次跳一级跳三次，或者第一次跳一级，第二次跳两级，或者第一次跳两级，第二次跳一级。所以有三种跳法。
 * 当台阶有四级时，青蛙可以选择：
 * 1、一次跳一级跳四次
 * 2、一次跳两级跳两次
 * 3、第一次跳一级，第二次跳一级，第三次跳两级
 * 4、第一次跳一级，第二次跳两级，第三次跳一级
 * 5、第一次跳两级，第二和第三次各跳一级
 * 可见当台阶有4级是一共有五种跳法。回过头看当台阶基础达到3级时，其跳法的规律就等于前面两级跳法之和了。这正是斐波那契额数列的规律
 */
package integration;

public class JumpStairs {
    /**
     * 用循环实现，没有栈溢出的风险
     */
    public static int jumpStairsByLoop(int n){
        if (n <= 2) {
            return n;
        }
        int first = 1;
        int second = 2;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }


    /**
     * 递归法实现，但要警惕调用栈溢出风险
     */
    public static int jumpStairsByRecursion(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return jumpStairsByRecursion(n - 1) + jumpStairsByRecursion(n - 2);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("跳上 " + n + " 级台阶的跳法有 " + jumpStairsByRecursion(n) + " 种。");
    }
}
