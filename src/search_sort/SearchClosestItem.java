package search_sort;

import com.sun.istack.internal.NotNull;
import jdk.internal.util.xml.impl.Pair;

import java.util.*;

/**
 * Created by ziweihan on 11/5/18
 *
 */
public class SearchClosestItem {
    /**
     * Algorithm used in Video summary that: given a random key that might not exist in the input,
     * find the closest smaller item from the input.
     * For example
     * @param key  9
     * @param input 1,4,6,8,23,78
     * @return  8
     */
    public static Long findClosestSmallerItem(long key, List<Long> input) {
        if(input == null || input.isEmpty())
            return null;

        if(input.size() == 1)
            return input.get(0);

        int L = 0;
        int R = input.size()-1;
        int M ;

        while(L < R) {
            M = (R + L) / 2;

            if (input.get(M) == key)
                return input.get(M);
            if (input.get(M) > key)
                R = M - 1;
            else
                L = M + 1;
        }

        if(R<0) {
            R = 0;
        }
        return input.get(R);

    }


    /**
     * @param key  9
     * @param input 1,4,6,8,23,78
     * @return  23
     */
    public static Long findClosestBiggerItem(long key, List<Long> input) {
        if(input == null || input.isEmpty())
            return null;

        if(input.size() == 1)
            return input.get(0);

        int L = 0;
        int R = input.size()-1;
        int M ;
        while(L <= R) {
            M = (R + L) / 2;
            if (input.get(M) == key)
                return input.get(M);
            if (input.get(M) > key)
                R = M - 1;
            else
                L = M + 1;
        }

        if(L >= input.size()){
            L = input.size()-1;
        }
        return input.get(L);

    }

    public static int findClosestSmallerItem(long key, Long[] input) {
        return Arrays.binarySearch(input, key);
    }


    /**
     * Given a key, find the closest item index
     * @param key
     * @param input
     * @return
     */
    public long findClosestItem(long key, List<Long> input) {
       long minDiff = Integer.MIN_VALUE;
       long closest = input.get(0);
       for(long num: input){
           long diff = Math.abs(key - num);
           if(diff<minDiff){
               minDiff = diff;
               closest = num;
           }
       }
       return closest;
    }


    public static void main(String[] args) {

        List<Long> list = new ArrayList<>();

        Map<Long, String> inputMap = new HashMap();
//        inputMap.put(11865L, "event1");
//        inputMap.put(19292L, "event2");
//        inputMap.put(19475L, "event3");
//        inputMap.put(20441L, "event6");
//        inputMap.put(39226L, "event4");
//        inputMap.put(46987L, "event5");
//        inputMap.put(49027L, "event7");
//
//        inputMap.put(51858L, "event8");
//        inputMap.put(55456L, "event9");
//        inputMap.put(56281L, "event10");
//        inputMap.put(57030L, "event11");
//        inputMap.put(62883L, "event12");
//        inputMap.put(64365L, "event13");
//        inputMap.put(65164L, "event14");

        inputMap.put(1L, "event1");
        inputMap.put(3L, "event2");
        inputMap.put(5L, "event3");
        inputMap.put(7L, "event0");
        inputMap.put(10L, "event6");
        inputMap.put(15L, "event4");
        inputMap.put(20L, "event5");
        inputMap.put(30L, "event7");


        list.addAll(inputMap.keySet());
        Collections.sort(list);
        long input = 4L;
        long result = findClosestBiggerItem(input,list);
        String resultString = inputMap.get(result);

        System.out.println("input is : " + String.valueOf(input));
        System.out.println("closest item sp is : " + String.valueOf(result));
        System.out.println("closest item event is : " + resultString);
    }
}
