package array;


/**
 * Created by ziweihan on 9/5/19.
 *
 * 79. Word Search
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
public class WordSearch_M {

    public boolean exist(char[][] board, String word) {
        int i, j;

        for (i = 0; i < board.length; i++) {
            for (j = 0; j < board[0].length; j++) {
                // if found the first char match, do the recursive search
                // if found the word, return true, otherwise keep searching
                if (exist(board, i, j, word)) {
                    return true;
                }

            }
        }
        return false;
    }

    //DFS function to find matches
    public boolean exist(char[][] board, int i, int j, String word) {
        // base cases

        // 1. if word is empty, meaning it found all matching characters
        if (word == null || word.isEmpty())
            return true;
        // 2. out of bound cases
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        // 3. not matching case
        if (board[i][j] != word.charAt(0)) {
            return false;
        }

        // 4. matching case
        // handling the case {{'A','A'}} "AAAA" should return false;
        // Trick: prevent from going backwards, change the current char to something else
        char temp = board[i][j];
        board[i][j] = '#';

        // shrink the word
        word = word.substring(1);
        boolean found =  (exist(board, i, j - 1, word) ||
                exist(board, i, j + 1, word) ||
                exist(board, i - 1, j, word) ||
                exist(board, i + 1, j, word));

        // bringing back the original char
        board[i][j] = temp;

        return found;
    }

    public static void main(String[] args) {
        WordSearch_M problem = new WordSearch_M();
        char[][] input = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
//        char[][] input = {{'A','A'}};

        System.out.print(problem.exist(input, "CCED"));


    }


}
