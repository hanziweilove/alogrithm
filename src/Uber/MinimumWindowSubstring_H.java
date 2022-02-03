package Uber;


/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every
 * character in t (including duplicates) is included in the window.
 * If there is no such substring, return the empty string "".
 * <p>
 * The testcases will be generated such that the answer is unique.
 * <p>
 * A substring is a contiguous sequence of characters within the string.
 * <p>
 * Sliding window
 */
public class MinimumWindowSubstring_H {
    public String minWindow(String s, String t) {
        if (s == null || t == null)
            return "";

        int minLength = s.length(); //minLength of the qualified string found so far
        int count = 0; //how many required character found
        String result = "wrong"; //final result of the min length string that contains t
        int[] letterCount = new int[128]; //ASCII array to record t's characters
        for (char c: t.toCharArray()) {
            letterCount[c]++;
        }
        int left = 0; //left index of the sliding window
        for (int right = 0; right < s.length(); right++) {
            letterCount[s.charAt(right)]--;
            if (letterCount[s.charAt(right)] >= 0) {// if found a char in t, increment count;
                count++;
            }
            while (count == t.length()) {
                if (minLength >= right - left + 1) {
                    minLength = right - left + 1;
                    result = s.substring(left, right + 1);
                }
                letterCount[s.charAt(left)]++;
                if (letterCount[s.charAt(left)] > 0) {
                    count--;
                }
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "AAOBECBANC";
        String t = "ABC";
        //output: "BANC"
        MinimumWindowSubstring_H problem = new MinimumWindowSubstring_H();
        System.out.print(problem.minWindow(s,t));
    }
}
