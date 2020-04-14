package queue;


import java.util.*;

public class GeneralizedQueue {
    int size; // total capacity of the queue
    Integer queue[]; // array to hold the elements of the queue
    int pointer; // specifies the index position of the last inserted item in the queue

    public GeneralizedQueue(int size, Integer queue[], int pointer) {
        this.size = size;
        this.queue = queue;
        this.pointer = pointer;
    }

    /**
     * Creates an empty queue.
     */
    public GeneralizedQueue() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of the queue :: ");
        size = sc.nextInt();
        queue = new Integer[size];
        pointer = -1; // indicates that the queue is empty initially
        for (int i = 0; i < queue.length; i++)
            insert(sc.nextInt()); //adds an element into the queue
    }

    /**
     * Checks if the queue is empty
     *
     * @return true if the queue is empty
     * and false otherwise.
     */
    public boolean isEmpty() {
        if (pointer == -1)
            return true;
        else
            return false;
    }

    /**
     * Add an item to the back of the queue.
     *
     * @param x the item to be addded to the queue
     */
    public void insert(Integer x) {
        if (pointer < size - 1) { /* if the current pointer position is less than the capacity of queue */
            pointer = pointer + 1; /* move the pointer to an empty location in the queue */
            queue[pointer] = x; /* place the item in that location */
        } else {
            System.out.println("The queue is already full");
        }


    }

    /**
     * delete and return the kth least recently inserted item
     * (the kth item "in line".)
     *
     * @param k indicates which position from the queue to be removed.
     *          The first item is in position 1.
     * @return the kth oldest item in the queue
     */
    public Integer delete(int k) {

        System.out.println("Position to delete : " + k);
        Integer item = Integer.valueOf(queue[k - 1]); /* take the element at the k-1 index position */

        System.out.println("Item deleted : " + item);
        for (int i = k - 1; i < pointer; i++) /* move the other elements one position before, overwriting the deleted item */
            queue[i] = queue[i + 1];
        pointer = pointer - 1; /* reduce the pointer one location before */
        return item;
    }

    public void displayQueue() {
        System.out.println("Elements of queue : ");
        for (int i = 0; i <= pointer; i++)
            System.out.println(queue[i]);
    }

    public static void main(String[] args) {
        int pointer = 4;
        Integer[] queue = new Integer[]{1, 2, 3, 4, 5};
        int size = queue.length;
        GeneralizedQueue generalizedQueue = new GeneralizedQueue(size, queue, pointer);
        generalizedQueue.displayQueue();

    }
}
