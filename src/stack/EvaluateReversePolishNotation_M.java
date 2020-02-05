package stack;

import java.util.Stack;

/**
 * Created by ziweihan on 4/11/19.
 *
 * 150 . Evaluate Reverse Polish Notation
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

 Valid operators are +, -, *, /. Each operand may be an integer or another expression.

 Note:

 Division between two integers should truncate toward zero.
 The given RPN expression is always valid. That means the expression would always evaluate to a
 result and there won't be any divide by zero operation.
 Example 1:

 Input: ["2", "1", "+", "3", "*"]
 Output: 9
 Explanation: ((2 + 1) * 3) = 9
 Example 2:

 Input: ["4", "13", "5", "/", "+"]
 Output: 6
 Explanation: (4 + (13 / 5)) = 6
 Example 3:

 Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 Output: 22
 Explanation:
 ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 = ((10 * (6 / (12 * -11))) + 17) + 5
 = ((10 * (6 / -132)) + 17) + 5
 = ((10 * 0) + 17) + 5
 = (0 + 17) + 5
 = 17 + 5
 = 22
 */
public class EvaluateReversePolishNotation_M {

    /**
     * Not working with Tokens1
     * @param tokens
     * @return
     */
    public int evalRPN_mine(String[] tokens) {
        int result = Integer.MIN_VALUE;
        Stack<String> stack = new Stack<>();
        for(String token: tokens){
            if(isOperator(token)){
                //pop stack twice to get operands
                int firstOperand ;
                int secondOperand;
                if (result > Integer.MIN_VALUE) {
                    secondOperand = result;
                } else {
                    if (stack.isEmpty()) continue;
                    secondOperand = Integer.valueOf(stack.pop());
                }
                if (stack.isEmpty()) continue;
                firstOperand = Integer.valueOf(stack.pop());
                result = compute(firstOperand, secondOperand, token);
            }else {
                // push on stack
                stack.push(token);
            }
        }
        return result;
    }


    public int evalRPN(String[] tokens) {
        int result;
        Stack<Integer> stack = new Stack<>();
        for(String token: tokens){
            if(isOperator(token)){
                //pop stack twice to get operands
                int firstOperand ;
                int secondOperand;

                if(stack.isEmpty()) continue;
                secondOperand = stack.pop();
                if (stack.isEmpty()) continue;
                firstOperand = stack.pop();
                result = compute(firstOperand, secondOperand, token);

                stack.push(result);
            }else {
                // push on stack
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }


    private boolean isOperator(String token){
        return token.equals("+") ||
                token.equals("-") ||
                token.equals("*") ||
                token.equals("/");
    }

    private int compute(int firstOperand, int secondOperand, String token){
        switch (token){
            case "+":
                return firstOperand + secondOperand;
            case "-":
                return firstOperand - secondOperand;
            case "*":
                return firstOperand * secondOperand;
            default:
                return firstOperand / secondOperand;
        }
    }

    public static void main(String[] args){
        EvaluateReversePolishNotation_M RPN = new EvaluateReversePolishNotation_M();
        String[] tokens =  {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};

        String[] tokens1 = {"-78","-33","196","+","-19","-","115","+","-","-99","/","-18","8","*","-86","-","-","16",
                "/","26","-14","-","-","47","-","101","-","163","*","143","-","0","-","171","+","120","*","-60","+",
                "156","/","173","/","-24","11","+","21","/","*","44","*","180","70","-40","-","*","86","132","-84",
                "+","*","-","38","/","/","21","28","/","+","83","/","-31","156","-","+","28","/","95","-","120","+",
                "8","*","90","-","-94","*","-73","/","-62","/","93","*","196","-","-59","+","187","-","143","/","-79",
                "-89","+","-"};
        System.out.print(RPN.evalRPN(tokens1));

    }

}
