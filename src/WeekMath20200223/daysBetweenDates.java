package WeekMath20200223;

import java.util.HashMap;
import java.util.Map;

/**
 * 5169. 日期之间隔几天
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-02-23 10:49
 */
public class daysBetweenDates {

    public static void main(String[] args) {

    }

    public int daysBetweenDates(String date1, String date2) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(2, 28);
//        map.put("22", 29);
        Integer[] arr = {1, 3, 5, 7, 8, 10, 12};
        for (Integer s : arr) {
            map.put(s, 31);
        }
        Integer[] arr2 = {4, 6, 9, 11};
        for (Integer s : arr2) {
            map.put(s,30);
        }

        String min = date1.compareTo(date2) >= 0 ? date2 : date1;

        String max = date1.compareTo(date2) < 0 ? date2 : date1;

        int ans = 0;

        if(min.split("-")[0].equals(max.split("-")[0]) && min.split("-")[1].equals(max.split("-")[1])) {
            return Integer.valueOf(max.split("-")[2]) - Integer.valueOf(min.split("-")[2]);
        }

        if(min.split("-")[0].equals(max.split("-")[0])) {
            for (int i = Integer.valueOf(Integer.valueOf(min.split("-")[1])) + 1; i < Integer.valueOf(max.split("-")[1]); i++) {
                if(i == 2 && isRun(Integer.valueOf(min.split("-")[0]))) {
                    ans += 29;
                    continue;
                }
                ans += map.get(i);
            }
            ans += Integer.valueOf(max.split("-")[2]);
            if("02".equals(min.split("-")[1]) && isRun(Integer.valueOf(min.split("-")[1]))) {
                ans += 29 - Integer.valueOf(min.split("-")[2]);
            }
            ans += map.get(Integer.valueOf(min.split("-")[1])) - Integer.valueOf(min.split("-")[2]);

            return ans;
        }





        for (int i = Integer.valueOf(min.split("-")[0]) + 1; i < Integer.valueOf(max.split("-")[0]); i++) {
            if(isRun(i)) {
                ans += 366;
            } else{
                ans += 365;
            }
        }
        for (int i = Integer.valueOf(Integer.valueOf(min.split("-")[1])) + 1; i < 13; i++) {
            if(i == 2 && isRun(Integer.valueOf(min.split("-")[0]))) {
                ans += 29;
                continue;
            }
            ans += map.get(i);
        }
        for (int i = 1; i < Integer.valueOf(max.split("-")[1]); i++) {
            if(i == 2 && isRun(Integer.valueOf(max.split("-")[0]))) {
                ans += 29;
                continue;
            }
            ans += map.get(i);
        }
        ans += Integer.valueOf(max.split("-")[2]);
        if("02".equals(min.split("-")[1]) && isRun(Integer.valueOf(min.split("-")[1]))) {
            ans += 29 - Integer.valueOf(min.split("-")[2]);
        }
        ans += map.get(Integer.valueOf(min.split("-")[1])) - Integer.valueOf(min.split("-")[2]);

        return ans;
    }


    public boolean isRun(int yearInt) {
        if((yearInt % 4 == 0 && yearInt % 100 != 0) || (yearInt % 100 == 0 && yearInt % 400 == 0)) {
            return true;
        }
        return false;
    }
}
