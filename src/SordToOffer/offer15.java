package SordToOffer;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-04-06 11:33
 */
public class offer15 {


    //常规解法

    /**
     * 常规解法
     *
     * 1001111001
     * 0000000001
     * 上面两个数作 & 运算，根据结果是不是0判断最后一位是不是1，然后第二个数左移一位
     *
     * 1001111001
     * 0000000010
     * 再次作 & 运算，根据结果是不是0判断倒数第二位是不是1，第二个数在左移一位，以此类推
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int flag = 1;
        int count = 0;
        while (flag != 0) {
            if((n & flag) != 0)
                count ++;
            flag = flag << 1;
        }

        return count;
    }


    /**
     * 装逼解法
     *
     * (n - 1) & n 得到的作用是：把n从右起第一个1变成0。
     * 重复上述运算知道把所有的1变成0，返回计算次数就是1的个数
     *
     *
     * @param n
     * @return
     */
    public int hammingWeight1(int n) {
        int count = 0;

        while (n != 0) {
            n = (n - 1) & n;
            count ++;
        }
        return count;
    }

}
