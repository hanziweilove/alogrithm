package math;

/**
 * Created by ziweihan on 5/14/19.
 */
public class PowerOfThree {

    public boolean isPowerOfThree(int n) {
        if(n==1) return true;
        if(n<3) return false;

        double num = n;
        while (num >= 3) {
            if (num == 3)
                return true;
            num = num / 3;
        }
        return false;
    }

    public static void main(String[] args){
        PowerOfThree powerOfThree = new PowerOfThree();
        System.out.print(powerOfThree.isPowerOfThree(54));
    }

}
