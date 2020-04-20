package WeekMatch20200405;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-04-05 10:53
 */
public class numSteps {

    public static void main(String[] args) {
        numSteps a = new numSteps();
        System.out.println(a.numSteps("1111011110000011100000110001011011110010111001010111110001"));
    }

    public String plusOne(String s) {
        char[] arrS = s.toCharArray();
        arrS[arrS.length - 1] = '0';
        for (int i = s.length() - 2; i >= 0; i--) {
            if(arrS[i] == '0') {
                arrS[i] = '1';
                return changeToString(arrS);
            }
            arrS[i] = '0';
        }
        return "1" + changeToString(arrS);
    }

    public String changeToString(char[] arr) {
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(String.valueOf(c));
        }
        return sb.toString();
    }

    public String divTwo(String s) {
        return s.substring(0, s.length() - 1);
    }

    public int numSteps(String s) {
        if("1".equals(s)) return 0;
        int step = 0;

        while (true) {
            if("1".equals(s)) return step;
            if('0' == (s.charAt(s.length() - 1))) {
                s = divTwo(s);
                step += 1;
            } else {
                s = plusOne(s);
                step += 1;
            }
        }

    }
}
