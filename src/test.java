import java.awt.*;
import java.io.ObjectInputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;
import java.util.List;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-03-28 20:54
 */
public class test {

    public static void main(String[] args) throws Exception{
        Class clazz = Integer.class.getDeclaredClasses()[0];

        Field f = clazz.getDeclaredField("cache");

        f.setAccessible(true);

        Integer[] i = (Integer[])f.get(clazz);

        i[129] = i[128];

        Integer a = 0;

        if(a == (Integer)0 && a == (Integer) 1) {
            System.out.println("success");
        }

        Map<String, String> map = new HashMap<>();
    }
}

