package laterWMS.WeekMatch20200419;

import java.util.*;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-04-19 10:49
 */
public class displayTable {

    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<String, Integer> map = new HashMap<>();
        Set<Integer> tableSet = new HashSet<>();
        Set<String> maueSet = new HashSet<>();
        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < orders.size(); i++) {
            tableSet.add(Integer.valueOf(orders.get(i).get(1)));
            maueSet.add(orders.get(i).get(2));
            if(!map.containsKey(orders.get(i).get(1) + "_" +orders.get(i).get(2))) {
                map.put(orders.get(i).get(1) + "_" +orders.get(i).get(2), 1);
            } else {
                map.put(orders.get(i).get(1) + "_" +orders.get(i).get(2), map.get(orders.get(i).get(1) + "_" +orders.get(i).get(2)) + 1);
            }
        }

        List<String> listMaue = new LinkedList<>(maueSet);
        Collections.sort(listMaue);
        listMaue.add(0, "Table");

        ans.add(listMaue);

        List<Integer> listTable = new ArrayList<>(tableSet);
        listTable.sort((a,b)->{
            return a - b;
        });


        List<String> tempList = new ArrayList<>();

        for (int i = 0; i < listTable.size(); i++) {
            tempList.add(String.valueOf(listTable.get(i)));
            for (int k = 1; k < listMaue.size(); k++) {
                if(map.containsKey(listTable.get(i) + "_" + listMaue.get(k))) {
                    tempList.add(String.valueOf(map.get(listTable.get(i) + "_" + listMaue.get(k))));

                }else {
                    tempList.add("0");
                }
            }
            ans.add(tempList);
            tempList = new ArrayList<>();
        }




        return ans;


    }
}
