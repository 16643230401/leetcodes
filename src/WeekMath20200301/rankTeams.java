package WeekMath20200301;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-03-01 10:57
 */
public class rankTeams {

    public static void main(String[] args) {
        rankTeams rankTeams = new rankTeams();
        String[] arr = {"ABC","ACB","ABC","ACB","ACB"};
        System.out.println(rankTeams.rankTeams(arr));
    }

    public String rankTeams(String[] votes) {
        if(votes.length == 1) return String.valueOf(votes[0].charAt(1));

        Map<Character, int[]> map = new HashMap<>();

        for (int i = 0; i < votes[0].length(); i++) {
            map.put(votes[0].charAt(i), new int[votes[0].length()]);
            map.get(votes[0].charAt(i))[i] = 1;
        }


        for(int i = 1; i < votes.length; i++) {
            for(int j = 0; j < votes[0].length(); j++) {
                map.get(votes[i].charAt(j))[j] ++;
            }
        }

        List<Map.Entry<Character, int[]>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, (entry1, entry2)->{
            int[] values1 = entry1.getValue();
            int[] values2 = entry2.getValue();

            for (int i = 0; i < votes[0].length(); i++) {
                if(values1[i] != values2[i]) {
                    return values2[i] - values1[i];
                }
            }

            return entry1.getKey() - entry2.getKey();

        });

        return list.stream().map(entry -> entry.getKey().toString()).collect(Collectors.joining());
    }
}
