package string;

/**
 * Created by ziweihan on 1/22/20.
 *
 * Given a list of words and two words word1 and word2, return the shortest
 * distance between these two words in the list.

 For example,
 Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

 Given word1 = “coding”, word2 = “practice”, return 3.
 Given word1 = "makes", word2 = "coding", return 1.
 */
public class ShortestWordDistance_E {

    public int shortestDistance(String[] words, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int minDistance = Integer.MAX_VALUE;
        for(int i = 0; i< words.length; i++){
            if(words[i].equals(word1)){
                index1 = i;
                if(index2 != -1) {
                    //if the first occurrence of word1 is there
                    minDistance = Math.min(minDistance, Math.abs(index1-index2));
                }
            }

            if(words[i].equals(word2)){
                index2 = i;
                if(index1 != -1) {
                    //if the first occurrence of word2 is there
                    minDistance = Math.min(minDistance, Math.abs(index2-index1));
                }
            }
        }
        return minDistance;

    }

    public static void main(String[] args) {
        ShortestWordDistance_E pro = new ShortestWordDistance_E();
        String[] words = {"practice", "ok", "practice", "word", "makes", "perfect", "practice", "makes"};
        int min = pro.shortestDistance(words, "practice", "makes");
        System.out.print("shortest distance is : "+ min);
    }


}
