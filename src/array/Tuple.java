package array;

/**
 * Created by ziweihan on 1/18/20.
 */
class Tuple implements Comparable<Tuple>{
    int x;
    int y;
    int val;

    public Tuple(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    @Override
    public int compareTo(Tuple o) {
        return this.val - o.val;
    }
}
