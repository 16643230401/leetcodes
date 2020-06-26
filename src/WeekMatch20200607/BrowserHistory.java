package WeekMatch20200607;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-06-07 11:18
 */
public class BrowserHistory {
    Stack<String> backs;
    Stack<String> forwords;

    public BrowserHistory(String homepage) {
        backs = new Stack<>();
        forwords = new Stack<>();
        backs.push(homepage);
    }

    public void visit(String url) {
        forwords.removeAllElements();
        backs.push(url);
    }

    public String back(int steps) {
        if(steps >= backs.size()) steps = backs.size() - 1;
        while(steps > 0) {
            forwords.push(backs.pop());
            steps --;
        }
        return backs.peek();
    }

    public String forward(int steps) {
        if(steps > forwords.size()) steps = forwords.size();
        while(steps > 0) {
            backs.push(forwords.pop());
            steps --;
        }
        return backs.peek();
    }
}
