package WeekMatch20200112;

/**
 * 1317. 将整数转换为两个无零整数的和
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-01-12 10:33
 */
public class getNoZeroIntegers {
    public static void main(String[] args) {
    getNoZeroIntegers getNoZeroIntegers = new getNoZeroIntegers();
        System.out.println(getNoZeroIntegers.getNoZeroIntegers(2)[0]);

        System.out.println(getNoZeroIntegers.getNoZeroIntegers(2)[1]);
    }

    public int[] getNoZeroIntegers(int n) {

        if(n == 2) return new int[]{1,1};
        int[] ans = new int[2];
        for (int i = 1; i < n / 2; i++) {
            if(!String.valueOf(i).contains("0") && !String.valueOf(n - i).contains("0")) {
                ans[0] = i;
                ans[1] = n - i;
                return ans;
            }
        }


        return ans;
    }
}
