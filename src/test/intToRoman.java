package test;

/**
 * <p>整数转罗马</p>
 *
 * @Author : bairuoyu
 * @Date : 2020-01-11
 * @Version : v1.0
 */
public class intToRoman {
    public static void main(String[] args) {

    }
    public String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        int[] moneys = new int[] {1000,900,500,400,100,90,50,40,10,9,5,4,1 };
        String[] moneyToStr = new String[] {"M", "CM", "D","CD","C","XC","L","XL","X", "IX", "V", "IV", "I" };
        int index = 0;
        while (num > 0)
        {
            if (num >= moneys[index])
            {
                stringBuilder.append(moneyToStr[index]);
                num -= moneys[index];
                index--;
            }
            index++;
        }
        return stringBuilder.toString();
    }
}
