package laterWMS.WeekMatch20200412;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-04-12 11:10
 */
public class entityParser {

    public static void main(String[] args) {
        String ss = "aijk";
        System.out.println(ss.substring(2, 2 + 2));
    }

    public String entityParser(String text) {
        Map<String, String> map = new HashMap<>();
        map.put("&quot;", "\"");
        map.put("&apos;", "\'");
        map.put("&amp;", "&");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");


        char[] arr = text.toCharArray();
        String temp;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == '&') {
                if(arr.length - i < 4) {
                    sb.append('&');
                    continue;
                }
                temp = text.substring(i, i + 4);
                if(map.containsKey(temp)) {
                    sb.append(map.get(temp));
                    i += 3;
                    continue;
                }
                if(arr.length - i < 5) {
                    sb.append('&');
                    continue;
                }
                temp = text.substring(i, i + 5);
                if(map.containsKey(temp)) {
                    sb.append(map.get(temp));
                    i += 4;
                    continue;
                }
                if(arr.length - i < 6) {
                    sb.append('&');
                    continue;
                }
                temp = text.substring(i, i + 6);
                if(map.containsKey(temp)) {
                    sb.append(map.get(temp));
                    i += 5;
                    continue;
                }
                if(arr.length - i < 7) {
                    sb.append('&');
                    continue;
                }
                temp = text.substring(i, i + 7);
                if(map.containsKey(temp)) {
                    sb.append(map.get(temp));
                    i += 6;
                    continue;
                }
                sb.append('&');
            } else {
                sb.append(arr[i]);
            }

        }

        return sb.toString();
    }

}
