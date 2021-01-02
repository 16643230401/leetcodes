package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-02-18 20:57
 */
public class test {

    class t {
        List<c> list;

        public List<c> getList() {
            return list;
        }

        public void setList(List<c> list) {
            this.list = list;
        }
    }

    class c {
        String b;
    }

    public static void main(String[] args) {
//        test t = new test();
//        t.test1();
        System.out.println(1^1);
    }

    public void test1() {
        List<c> list = new ArrayList<>();
        c c = new c();
        c.b = "a";
        list.add(c);
        c = new c();
        c.b = "a";
        list.add(c);
        c = new c();
        c.b = "b";
        list.add(c);
        c = new c();
        c.b = "b";
        list.add(c);
        c = new c();
        c.b = "a";
        list.add(c);c = new c();
        c.b = "a";
        list.add(c);

        t t = new t();
        t.setList(list);


        for (int i = 0; i < t.getList().size(); i++) {
            if(t.getList().get(i).b.equals("b")) {
                t.getList().remove(i);
                i--;
            }
        }

        for (int i = 0; i < t.getList().size(); i++) {
            System.out.println(t.getList().get(i).b);
        }









    }
}
