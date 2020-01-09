package test;


public class myAtoi {

    public static void main(String[] args) {
        myAtoi myAtoi = new myAtoi();
        System.out.println(myAtoi.myAtoi("-2147483649"));
    }


    public int myAtoi(String str) {
        if(str.length() == 0) return 0;
        str = str.trim();
        int ans  = 0;
        char[] strToChar = str.toCharArray();
        boolean flag = false;
        int j = 0;
        if(strToChar[j] == '-') {
            flag = true;
            j = 1;
        } else if(strToChar[j] == '+') {
            j = 1;
        }
        for (int i = j ; i < strToChar.length; i++) {

            if(strToChar[i] >= '0' && strToChar[i] <= '9') {
                if(!flag && (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && (strToChar[i] - '0') > Integer.MAX_VALUE % 10))) {
                    return Integer.MAX_VALUE;
                } else if(flag && (-ans < Integer.MIN_VALUE / 10 || (-ans == Integer.MIN_VALUE / 10 && ('0' - strToChar[i]) < Integer.MIN_VALUE % 10))) {
                    return Integer.MIN_VALUE;
                } else {
                    ans = ans * 10 + (strToChar[i] - '0');
                }
            } else {
                break;
            }
        }

        return flag ? 0 - ans : ans;

    }
}
