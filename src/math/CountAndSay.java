package math;

/**
 * Created by ziweihan on 3/26/19.
 */
public class CountAndSay {

    public static String countAndSay(int n) {
        if(n == 1)
            return "1";
        if(n == 2)
            return "11";
        if(n ==3)
            return "21";

        StringBuilder result = new StringBuilder();
        String previous = countAndSay(n-1);
        int i = 0;
        int j = 1;
        while(i< previous.length()-1) {
            if(previous.charAt(i) != previous.charAt(i+i)){
                result.append(j);
                result.append(previous.charAt(i));
                j = 1;
            }
            j++;
            i++;
        }

        return result.toString();
    }

    //Dynamic programming
    public static String countAndSayDP(int n){
        if(n == 1)
            return "1";

        String result = "1";
        int count = 0;
        for(int i = 2 ; i <= n ; i++) {
            StringBuilder sb  = new StringBuilder();
            int j = 0;
            while(j<result.length()) {
                char current = result.charAt(j);
                while(j<result.length() && current == result.charAt(j)){
                    count++;
                    j++;
                }
                sb.append(count);
                sb.append(current);
                count = 0;
            }
            result = sb.toString();

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.print(countAndSayDP(5));
    }
}
