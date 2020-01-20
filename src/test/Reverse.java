package test;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2019-08-02 22:46
 * @problem 7.整数反转
 */
public class Reverse {
    public static void main(String[] args) {
        System.out.println(Reverse.reverseInt(-123));
    }

    /**
     *
     * 7.整数反转
     * 思路：
     *  设置一个标志数ans存放反转之后的结果，原数字x右移一位，获取余数flag，然后将ans左移一位，将余数flag填补，
     *  当原数x右移至等于0时，就得到最后结果ans，但是由于题设规定32位存储，所以可能造成溢出，需要在ans进行左移之前，
     *  对ans进行判断，判断条件如下所示
     * 判断条件：
     *  1.若x>0，则每次将ans左移之前都应进行判断，是否有ans > Integer.MAX_VALUE / 10，若大于说明左移之后会造成溢出,
     *    另外，若ans = Integer.MAX_VALUE / 10，就需要进行进一步判断，余数是否大于7（Integer.MAX_VALUE个位为7）
     *  2.若x<0，类似，将ans与Integer.MIN_VALUE进行比较，若相同，将余数与-8进行比较大小。
     * @param x
     * @return ans
     */
    public static int reverseInt(int x) {

        int ans = 0;
        int flag = 0;
        final int max = Integer.MAX_VALUE;
        final int min = Integer.MIN_VALUE;
        while (x != 0) {
            //获取x右移之后的余数，并进行判断
            flag = x % 10;
            if (ans > max / 10 || (ans == max && flag > 7)) return 0;
            if (ans < min / 10 || (ans == min && flag < -8)) return 0;
            //ans左移并加上余数
            ans  = ans * 10 + flag;
            //x相应右移
            x /= 10;
        }
        return ans;
    }
}
