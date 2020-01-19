package WeekMAtch20200119;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>竖直打印</p>
 *
 * @Author : bairuoyu
 * @Date : 2020-01-19
 * @Version : v1.0
 */
public class printVertically {
    public static void main(String[] args) {
        printVertically printVertically = new printVertically();
        System.out.println(printVertically.printVertically("AA BBB C DDDD EEEEE F"));
    }

    public List<String> printVertically(String s) {
        String[] arr = s.split(" ");
        List<String> list = new ArrayList<>();
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            maxLen = Math.max(arr[i].length(), maxLen);
        }
        String k = "";
        String temp = "";
        for (int j = 0; j < maxLen; j++) {
            temp = "";
            k = "";
            for (int i = 0; i < arr.length; i++) {
                if(j >= arr[i].length()) {
                    k += " ";
                    continue;
                }
                temp += k + arr[i].charAt(j);
                k = "";
            }
            list.add(temp);
        }

        return list;
    }
}
