package WeekMatch20200112;

/**
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
}
