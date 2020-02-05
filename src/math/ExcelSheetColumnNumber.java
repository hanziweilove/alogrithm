package math;

/**
 * Created by ziweihan on 5/13/19.
 Given a column title as appear in an Excel sheet, return its corresponding column number.

 For example:

 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28
 ...
 Example 1:

 Input: "A"
 Output: 1
 Example 2:

 Input: "AB"
 Output: 28
 Example 3:

 Input: "ZY"
 Output: 701

 AAA = 26 power(2) *1 + 26 power(1) *1+ 26 power(0) * 1
 */
public class ExcelSheetColumnNumber {

    public int titleToNumber(String s) {
        int val = 0;
        for(int i = 0; i < s.length(); i++){
            int index = s.length() - i - 1;
            char col = s.charAt(index);
            int colCharVal = col - 'A' + 1;
            val += Math.pow(26,i) * colCharVal;
        }

        return val;
    }

    public static void main(String[] args){
        String input = "ZY";
        ExcelSheetColumnNumber Solution = new ExcelSheetColumnNumber();
        System.out.print(Solution.titleToNumber(input));
    }
}
