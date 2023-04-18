package implementation.dataStructures.stack;

import java.util.Stack;

public class InterviewQuestion {
    public static String reverseString(String in) {
        if (in == null || in.equals(""))
            throw new IllegalArgumentException();

        var stack = new Stack<Character>();

        for (Character c : in.toCharArray()) {
            stack.push(c);
        }

        StringBuilder result = new StringBuilder();

        while (!stack.isEmpty())
            result.append(stack.pop());

        return result.toString();
    }
}
