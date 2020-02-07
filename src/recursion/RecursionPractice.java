package recursion;

/**
 * Created by ziweihan on 2/7/20.
 */
public class RecursionPractice {

    void printFun(int test) {
        if (test == 0)
            return;

        System.out.printf("%d ", test);
        printFun(test - 1); // statement 2
        System.out.printf("%d ", test);

    }

    public static void main(String[] args) {
        int test = 3;
        RecursionPractice solution = new RecursionPractice();
        solution.printFun(test);
        //3,2,1 -> 1,2,3
    }
}
