package stack;

import java.util.Stack;

/**
 * Created by ziweihan on 4/10/19.
 *
 * 739. Daily Temperatures
 *
 * Given a list of daily temperatures T, return a list such that, for each day in the input,
 * tells you how many days you would have to wait until a warmer temperature.
 * If there is no future day for which this is possible, put 0 instead.
 * <p>
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 * <p>
 * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 */
public class DailyTemperatures_M {

    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        Stack<PairTemp> stack = new Stack<>();

        for (int i = T.length - 1; i >= 0; i--) {
            int curTemp = T[i];
            PairTemp curTemperaturePair = new PairTemp(i,curTemp);

            while (!stack.isEmpty()) {
                PairTemp topTemperaturePair = stack.peek();
                int topTemp = topTemperaturePair.temp;
                int topDay = topTemperaturePair.day;

                if (topTemp <= curTemp) {
                    stack.pop();
                } else {
                    result[i] = topDay - i;
                    break;
                }
            }

            stack.push(curTemperaturePair);
        }
        return result;
    }

    class PairTemp{
        public int day;
        public int temp;

        public PairTemp(int day, int temp) {
            this.day = day;
            this.temp = temp;
        }


    }

    public static void main(String[] args) {
        DailyTemperatures_M dailyTemperatures = new DailyTemperatures_M();
        int[] T1 = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] T2 = {89, 62, 70, 58, 47, 47, 46, 76, 100, 70};
        int[] result = dailyTemperatures.dailyTemperatures(T2);

    }


}
