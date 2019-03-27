import java.security.PublicKey;
import java.util.Vector;

/**
 * Priority Queue Interface
 *  Extracted from Java Structures Chapter 13 Priority Queues
 * @param <E>
 */
public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {

    //Atribute: Vector that saves the nodes in HeapOrder
    protected Vector<E> data;

    /**
     * Constructor of a new instance of VectorHeap
     */
    public VectorHeap() {
        data = new Vector<E>();
    }

    /**
     * Constructor of a new instance of VectorHeap
     * Constructs a new Priority Queue from an unordered vector
     * @param v
     */
    public VectorHeap(Vector<E> v) {
        int i;
        data = new Vector<E>(v.size());
        for (i = 0; i < v.size(); i++) {//Add element to the heap
            add(v.get(i));
        }
    }

    /**
     * Returns parent node at i
     * @param i
     * @return
     */
    protected static int parent(int i) {
        return (i-1)/2;
    }

    /**
     * Returns left child of parent node at i
     * @param i
     * @return
     */
    protected static int left(int i) {
        return 2*i+1;
    }

    /**
     * Returns right child of parent node at i
     * @param i
     * @return
     */
    protected static int right(int i) {
        return (2*i+1) + 1;
    }

    /**
     * Moves node to appropiate position upwards
     * @param leaf
     */
    protected void percolateUp(int leaf) {
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0 &&
                (value.compareTo(data.get(parent)) < 0))
        {
            data.set(leaf,data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf,value);
    }

    /**
     * Element is added to VectorHeap
     * @param value
     */
    public void add(E value){
        data.add(value);
        percolateUp(data.size()-1);
    }

    /**
     * Moves node to appropiate position downwards
     * @param root
     */
    protected void pushDownRoot(int root) {
        int heapSize = data.size();
        E value = data.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize)
            {
                if ((right(root) < heapSize) &&
                        ((data.get(childpos+1)).compareTo
                                (data.get(childpos)) < 0))
                {
                    childpos++;
                }
                if ((data.get(childpos)).compareTo
                        (value) < 0)
                {
                    data.set(root,data.get(childpos));
                    root = childpos;
                } else {
                    data.set(root,value);
                    return;
                }
            } else {
                data.set(root,value);
                return;
            }
        }
    }

    /**
     * Returns first element
     * @return
     */
    public E getFirst(){
        return data.firstElement();
    }

    /**
     * Size of the Heap
     * @return
     */
    public int size(){
        return data.size();
    }

    /**
     * Returns and removes minimum value from queue
     * @return
     */
    public E remove() {
        E minVal = getFirst();
        data.set(0,data.get(data.size()-1));
        data.setSize(data.size()-1);
        if (data.size() > 1) pushDownRoot(0);
        return minVal;
    }
}
