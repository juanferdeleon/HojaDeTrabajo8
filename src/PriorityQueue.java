/**
 * Priority Queue Interface
 * Extracted from Java Structures Chapter 13 Priority Queues
 */
public interface PriorityQueue<E extends Comparable<E>> {

    /**
     * Returns the minimum value in priority queue
     * @return
     */
    public E getFirst();

    /**
     * Returns and removes minimum value from queue
     * @return
     */
    public E remove();

    /**
     * Value is added to priority queue
     * @param value
     */
    public void add(E value);

    /**
     * Returns true iff no elements are in queue
     * @return
     */
    //public boolean isEmpty();

    /**
     * Returns number of elements within queue
     * @return
     */
    public int size();

    /**
     * Removes all elements from queue
     */
    //public void clear();

}
