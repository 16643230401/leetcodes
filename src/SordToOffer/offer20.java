package SordToOffer;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-04-21 21:09
 */
public class offer20 {

    public static void main(String[] args) {
        offer20 o = new offer20();
        System.out.println(o.isNumber2("-1.e49046 "));
    }

    /**
     * 提供测试用例的人脑子有问题
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        char[] arr = s.trim().toCharArray();

        if(arr.length == 0) return false;
        int temp = 0;
        if((arr[temp] == '-' || arr[temp] == '+') && temp != arr.length - 1) temp += 1;
        if(arr[temp] == 'E' || arr[temp] == 'e' || arr[temp] == '.') return false;

        int isE = 0;
        int pointCount = 0;
        for (int i = temp; i < arr.length; i++) {
            if(!isNCheck(arr[i])) return false;
            if(arr[i] == 'E' || arr[i] == 'e') {
                if(isE > 0) return false;
                isE ++;
                if(i == arr.length - 1 || ((arr[i + 1] == '-' || arr[i + 1] == '+') && i + 1 == arr.length - 1)) return false;
            }
            else if(arr[i] == '.') {
                if(isE > 0 || pointCount > 0 || i == arr.length - 1 || arr[i + 1] == 'E' || arr[i + 1] == 'e') return false;
                pointCount ++;

            }
        }

        return true;
    }

    public boolean isNCheck(char c) {
        if((c >= '0' && c <= '9') || c == '.' || c == 'e' || c == 'E') return true;
        return false;
    }


    public boolean isNumber2(String s) {
        if(s.length() == 0) return false;
        char[] arr = s.toCharArray();
        char[][] dfaChart = {
                {'b', 'c', 'd', 'j', 'a', 'j'},
                {'j', 'c', 'd', 'j', 'j', 'j'},
                {'j', 'c', 'e', 'f', 'i', 'j'},
                {'j', 'e', 'j', 'j', 'j', 'j'},
                {'j', 'e', 'j', 'f', 'i', 'j'},
                {'g', 'h', 'j', 'j', 'j', 'j'},
                {'j', 'h', 'j', 'j', 'j', 'j'},
                {'j', 'h', 'j', 'j', 'i', 'j'},
                {'j', 'j', 'j', 'j', 'i', 'j'}
        };

        char status = 'a';
        for (int i = 0; i < arr.length; i++) {
            status = dfaChart[status - 'a'][getcol(arr[i])];
            if(status == 'j') return false;
        }


        if("cehi".contains(String.valueOf(status))) return true;
        return false;
    }

    public int getcol(char c) {
        if(c == '+' || c == '-') return 0;
        if(c <= '9' && c >= '0') return 1;
        if(c == '.') return 2;
        if(c == 'e' || c == 'E') return 3;
        if(c == ' ') return 4;
        return 5;
    }



}
