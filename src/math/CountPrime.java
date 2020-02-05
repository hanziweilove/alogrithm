package math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ziweihan on 3/29/19.
 */
public class CountPrime {

    public int countPrimes(int n) {
        if (n < 3) return 0;

        List<Integer> primeList = new ArrayList<>();
        primeList.add(2);
        for (int i = 3; i < n; i++) {
            boolean isPrime = true;
            for (Integer prime : primeList) {
                if (i % prime == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeList.add(i);
            }
        }
        return primeList.size();
    }


    public static void main(String[] args) {
        CountPrime countPrime = new CountPrime();
        System.out.print(countPrime.countPrimes(19));

    }
}
