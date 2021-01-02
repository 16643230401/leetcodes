package laterWMS.WeekMatch20200419;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-04-19 10:33
 */
public class reformat {

    public String reformat(String s) {
        char[] arr1 = s.toCharArray();

        List<Character> listNum = new ArrayList<>();
        List<Character> listWord = new ArrayList<>();

        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] >= '0' && arr1[i] <= '9') {
                listNum.add(arr1[i]);
            }else {
                listWord.add(arr1[i]);

            }
        }

        if(Math.abs(listNum.size() - listWord.size()) > 1) return "";

        StringBuilder sb = new StringBuilder();

        List<Character> listD = listNum.size() >= listWord.size() ? listNum : listWord;
        List<Character> listX = listNum.size() > listWord.size() ? listWord : listNum;

        for (int i = 0; i < listX.size(); i++) {
            sb.append(listD.get(i));
            sb.append(listX.get(i));
        }

        if(listD.size() - listX.size() > 0) sb.append(listD.get(listD.size() - 1));

        return sb.toString();

    }
}
