import java.util.Stack;

public class SortStack {
    static Stack<Integer> sort(Stack<Integer> s) {
        Stack<Integer> retStack = new Stack<>();
        while(!s.empty()) {
            int temp = s.pop();
            while(!retStack.empty() && temp < retStack.peek()) {
                s.push(retStack.pop());
            }
            retStack.push(temp);
        }
        return retStack;
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(4);
        s.push(67);
        s.push(82);
        s.push(32);
        s.push(46);
        Stack<Integer> sortedStack = sort(s);
        System.out.println(sortedStack.toString());
//        while(!sortedStack.empty()) {
//
//        }
    }
}