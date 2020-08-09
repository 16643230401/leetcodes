package ByteDance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-07-31 19:37
 */
public class BD1 {
    public static void main(String[] args) {
        BD1 bd1 = new BD1();
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(5);
        list.add(12);

        System.out.println(bd1.findExactly(list, 7));
    }

    public int findExactly(List<Integer> input, int target) {
        int min = 0;
        int max = 0;
        int len = input.size();

        for (int i = 0; i < len; i++) {
            if(target >= min && target <= max) return i;
            if(input.get(i) < min) {
                min = min - input.get(i);
            }
            else if(input.get(i) > max) {
                min = input.get(i) - max;
            }

            max = max + input.get(i);
        }


        return -1;
    }
}
