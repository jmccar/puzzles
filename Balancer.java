import java.util.*;

class Balancer {


    static char getLast(List < Character > stack) {

        int size = stack.size();
        char result = stack.get(size - 1);

        return result;
    }

    static void removeLast(List < Character > stack) {

        int size = stack.size();
        stack.remove(size - 1);

    }
    static boolean check(String input) {

        boolean result = false;

        List < Character > stack = new ArrayList < > ();

        for (int i = 0; i < input.length(); i++) {

            char current = input.charAt(i);
            if (current == '(' || current == '[') {

                stack.add(current);
            } else {

                if (current == ']' && getLast(stack) == '[') {

                    removeLast(stack);

                } else if (current == ')' && getLast(stack) == '(') {

                    removeLast(stack);
                } else {

                    return false;
                }

            }



        }

        result = (stack.size() == 0);

        return result;



    }

    public static void main(String a[]) {

        System.out.println(Balancer.check("[()]")); // true
        System.out.println(Balancer.check("(()[])")); // true
        System.out.println(Balancer.check("([)]")); // false

        System.out.println(Balancer.check("[(()])")); // false

        System.out.println(Balancer.check("([(([[(([]))]]))])")); // true
        System.out.println(Balancer.check("[](()()[[]])()[]([])")); // true
        System.out.println(Balancer.check("([((([(([]))])))))])")); // false
        System.out.println(Balancer.check("[](()()[[]])[][[([])")); // false
    }
}
