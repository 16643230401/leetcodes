package test;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-02-09 20:03
 */
public class numDecodings {

    public static void main(String[] args) {
        numDecodings numDecodings = new numDecodings();
        System.out.println(numDecodings.numDecodings("10"));

    }

    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int[] arr = new int[chars.length];
        String str;
        if(chars[0] == '0') return 0;
        if(chars.length <= 1) return 1;
        arr[0] = 1;
        str = String.valueOf(chars[0]) + String.valueOf(chars[1]);
        if(chars[1] == '0' && Integer.valueOf(str) > 26) return 0;
        if(chars[1] != '0' && Integer.valueOf(str) <= 26) {
            arr[1] = 2;
        } else {
            arr[1] = 1;
        }

        for (int i = 2; i < chars.length; i++) {
            str = String.valueOf(chars[i - 1]) + String.valueOf(chars[i]);
            if(chars[i] != '0') {
                if(chars[i - 1] != '0' && Integer.valueOf(str) <= 26){
                    arr[i] = arr[i - 1] + arr[i - 2];
                } else {
                    arr[i] = arr[i - 1];
                }
            } else if(chars[i] == '0'){
                if(chars[i - 1] != '0' && Integer.valueOf(str) <= 26){
                    arr[i] = arr[i - 2];
                } else {
                    return 0;
                }
            }
        }

        return arr[s.length() - 1];

    }
}
