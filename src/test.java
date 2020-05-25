import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-03-28 20:54
 */
public class test {

    public static void main(String[] args) {
        String str = "38.kkk";
        BigDecimal a ;
        try {
            a = new BigDecimal(str);
        } catch (Exception e) {
            a = new BigDecimal("0.00");
        }
        System.out.println(String.valueOf(a.intValue()));
    }

    public void RunTest() {
        ArrayList list = new ArrayList();

        list.add(1);
        list.add("s");

        System.out.println(list);
    }


}
