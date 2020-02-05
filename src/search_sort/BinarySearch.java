package search_sort;

import java.util.*;

/**
 * Created by ziweihan on 11/5/18
 *
 */
public class BinarySearch {

    /**
     * return the index of the found item,
     * return -1 if not found.
     * @param input
     * @param target
     * @return
     */
    public int binary_search(int[] input, int target){
        int L = 0;
        int R = input.length;
        int M = 0;
        while(L<R){
            M = (L+R)/2;
            if(input[M] == target) {
                return M;
            }
            if(input[M]< target){
                //target is on the right
                L = M;
            }else {
                R = M;
            }
        }
        return -1;
    }
    /**
     * Algorithm used in Video summary that: given a random key that might not exist in the input,
     * find the closest smaller item from the input.
     * For example
     * @param key  9
     * @param input 1,4,6,8,23,78
     * @return  8
     */
    public Long findClosestSmallerItem(long key, List<Long> input) {
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
    public Long findClosestBiggerItem(long key, List<Long> input) {
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
     * Given an unsorted array and a key, find the closest item index
     * @param key
     * @param input
     * @return
     */
    public long findClosestItem(long key, List<Long> input) {
       long minDiff = Integer.MAX_VALUE;
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

    /**
     0  1  2   3   4   5   6   7   8   9  <- indexes
     2 42 82 122 162 202 242 282 322 362  <- values
     L             M                   H  L=0, H=9, M=4, 162 higher, H<-M
     L     M       H                      L=0, H=4, M=2, 82 lower/equal, L<-M
           L   M   H                      L=2, H=4, M=3, 122 higher, H<-M
           L   H                          L=2, H=3, difference of 1 so exit
               ^
               |
               H (122-112=10) is closer than L (112-82=30) so choose H

     The idea is to find the last two L and R and compare which one is bigger
     */
    public long findClosestItem_BS(long key, List<Long> input){
        int L = 0;
        int R = input.size()-1;
        int M;
        while(L<R){
            M = (L+R)/2;
            if(key>input.get(M)){
                L = M;
            }else{
                //key <= input.get(mid)
                R = M;
            }
            //this is the condition before loop stops.
            //when there are only two numbers left, compare which one is closer.
            if(R-L == 1){
                if(Math.abs(input.get(R)-key) < Math.abs(input.get(L)-key)){
                    return input.get(R);
                }else{
                    return input.get(L);
                }
            }

        }
        return key;
    }


    public static void main(String[] args) {
        List<Long> list_1 = Arrays.asList(1L,5L,6L,9L,13L,24L,57L,89L);
        List<Long> list_2 = Arrays.asList(1L,5L,6L,7L,9L,13L,24L,57L,89L);
        List<Long> list_3 = Arrays.asList(1L,50L,60L,90L,130L,240L,570L,890L);

        BinarySearch solution = new BinarySearch();
        System.out.print(solution.findClosestItem_BS(7L, list_3));


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

//        inputMap.put(1L, "event1");
//        inputMap.put(3L, "event2");
//        inputMap.put(5L, "event3");
//        inputMap.put(7L, "event0");
//        inputMap.put(10L, "event6");
//        inputMap.put(15L, "event4");
//        inputMap.put(20L, "event5");
//        inputMap.put(30L, "event7");
//
//
//        list.addAll(inputMap.keySet());
//        Collections.sort(list);
//        long input = 4L;
//        long result = findClosestBiggerItem(input,list);
//        String resultString = inputMap.get(result);
//
//        System.out.println("input is : " + String.valueOf(input));
//        System.out.println("closest item sp is : " + String.valueOf(result));
//        System.out.println("closest item event is : " + resultString);
    }
}
