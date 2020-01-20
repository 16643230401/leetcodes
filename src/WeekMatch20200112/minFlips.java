package WeekMatch20200112;

/**
 * 	1318.或运算的最小翻转次数
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-01-12 10:44
 */
public class minFlips {
    public static void main(String[] args) {
        minFlips minFlips = new minFlips();
        System.out.println(minFlips.minFlips(2,6,5));
    }

    public int minFlips(int a, int b, int c) {
        int ans = 0;
        String shorter = Integer.toBinaryString(a < b ? a + (int)Math.pow(2, 30) : b + (int)Math.pow(2, 30));
        String longer = Integer.toBinaryString(a >= b ? a + (int)Math.pow(2, 30) : b + (int)Math.pow(2, 30));
        String strC = Integer.toBinaryString(c + (int)Math.pow(2, 30));

        int len = longer.length() - 1;

        while (len > 0) {
            if((Integer.valueOf(longer.charAt(len)) | Integer.valueOf(shorter.charAt(len))) != Integer.valueOf(strC.charAt(len))) {
                if(longer.charAt(len) == '1' && shorter.charAt(len) == '1') {
                    ans += 2;

                }else {
                    ans += 1;
                }
            }
            len --;
        }
        if((Integer.valueOf(longer.charAt(0) - 1) | Integer.valueOf(shorter.charAt(0) - 1)) != Integer.valueOf(strC.charAt(0) - 1)) {
            if(longer.charAt(0) == '2' && shorter.charAt(0) == '2') {
                ans += 2;

            }else {
                ans += 1;
            }
        }
        return ans;
    }

    public int minFlips2(int a, int b, int c) {
        int count = 0;
        while (c > 0 || a > 0 || b > 0) {
            int tempC = c & 1;
            int tempA = a & 1;
            int tempB = b & 1;
            if (tempC != (tempA | tempB)) {
                if (tempC == 0) {
                    count += (tempA == tempB ? 2 : 1);
                } else {
                    count += 1;
                }
            }
            c = c >> 1;
            a = a >> 1;
            b = b >> 1;
        }
        return count;
    }

//    作者：user8300R
//    链接：https://leetcode-cn.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/solution/xiang-you-wei-yi-qu-ge-wei-zuo-huo-yun-suan-by-use/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
