package Model;

import java.util.Stack;
public class Calc {

    public double solveEquation(String expr){
        double result = getAnswer(setRPN(expr));
        return result;
    }

    protected String setRPN(String expr) {
        String current = "";
        Stack<Character> stack = new Stack<>();
        int priority;

        expr.replaceAll("//","|");

        for (int i = 0; i < expr.length(); i++) {
            priority = getPriority(expr.charAt(i));

            switch (priority) {
                case -1:
                    current += ' ';
                    while (getPriority(stack.peek()) != 1) {
                        current += stack.pop();
                    }
                    stack.pop();
                    break;
                case 0:
                    current += expr.charAt(i);
                    break;
                case 1:
                    stack.push(expr.charAt(i));
                    break;
                default:
                    current += ' ';
                    while (!stack.empty()) {
                        if (getPriority(stack.peek()) >= priority) {
                            current += stack.pop();
                        } else break;
                    }
                    stack.push(expr.charAt(i));
                    break;
            }
        }

        while (!stack.empty()) {
            current += stack.pop();
        }

        return current;
    }

    protected double getAnswer(String rpn) {
        String value = new String();
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < rpn.length(); i++) {
            if (rpn.charAt(i) == ' ') continue;

            if (getPriority(rpn.charAt(i)) == 0) {
                while (rpn.charAt(i) != ' ' && getPriority(rpn.charAt(i)) == 0) {
                    value += rpn.charAt(i++);
                    if (i == rpn.length()) break;
                }
                stack.push(Double.parseDouble(value));
                value = new String();
            }

            if (getPriority(rpn.charAt(i)) > 1) {
                double value1 = stack.pop(), value2 = stack.pop();

                switch (rpn.charAt(i)){
                    case '+':
                        stack.push(value2 + value1);
                        break;
                    case '-':
                        stack.push(value2 - value1);
                        break;
                    case '*':
                        stack.push(value2 * value1);
                        break;
                    case '/':
                        stack.push(value2 / value1);
                        break;
                    case '^':
                        stack.push(Math.pow(value2, value1));
                        break;
                    case '%':
                        stack.push(value2 % value1);
                        break;
                    case '|':
                        stack.push((double)((int)Math.round(value2) / (int)Math.round(value1)));
                        break;
                }
            }
        }
        return stack.pop();
    }

    protected int getPriority (char token){
        return switch (token) {
            case '^' -> 5;
            case '/', '*' -> 4;
            case '%', '|' -> 3;
            case '+', '-' -> 2;
            case '(' -> 1;
            case ')' -> -1;
            default -> 0;
        };
    }
}
