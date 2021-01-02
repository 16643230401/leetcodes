package laterWMS.WeekMatch20200329;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-03-29 11:18
 */
public class UndergroundSystem {
    Map<String,Integer[]> ansMap;
    Map<Integer,String[]> inMap;

    public UndergroundSystem() {
        ansMap = new HashMap<>();
        inMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        String[] str = new String[2];
        str[0] = stationName;
        str[1] = String.valueOf(t);
        inMap.put(id, str);
    }

    public void checkOut(int id, String stationName, int t) {
        String[] str = inMap.get(id);
        String name = getRoute(str[0], stationName);
        if(ansMap.keySet().contains(name)) {
            ansMap.get(name)[0] += t - Integer.valueOf(str[1]);
            ansMap.get(name)[1]++;
        } else {
            Integer[] temp = {t - Integer.valueOf(str[1]), 1};
            ansMap.put(name, temp);
        }
        inMap.remove(id);
    }

    public String getRoute(String startStation, String endStation) {
        StringBuilder sb = new StringBuilder();
        sb.append(startStation).append("_").append(endStation);
        return sb.toString();
    }

    public double getAverageTime(String startStation, String endStation) {
        String name = getRoute(startStation, endStation);
        Integer[] ansArr = ansMap.get(name);
        return (double)ansArr[0] / (double)ansArr[1];
    }
}

