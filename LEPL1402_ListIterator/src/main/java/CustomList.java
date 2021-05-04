import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;

import java.lang.Iterable;
import java.util.Iterator;

public class CustomList<Item> implements Iterable<Item> {

    private int size;
    private ListNode<Item> first;
    private ListNode<Item> last;

    public CustomList() {
        first=null;
        last=null;
        size = 0;
    }
    /*
     * Add an element to the list
     *
     * The element to add at the end of the list
     */
    public void add(Item e) {
        ListNode<Item> n = new ListNode<>(e);
        if (first == null) {
            first = n;
            last = n;
        } else {
            last.setNext(n);
            last = n;
        }
        size += 1;
    }

    /**
     * Pop the first element of the list
     *
     * @return The first element in the list
     */
    public Item pop() throws NoSuchElementException {
        if (first == null)
            throw new NoSuchElementException();
        Item toReturn = first.getItem();
        first = first.getNext();
        size -= 1;
        return toReturn;
    }

    private class CustomIterator implements Iterator<Item> {

        private ListNode<Item> current = first;
        private final int sizeInit = size;

        private boolean failFastCheck() {
            if (size != sizeInit){
                throw new ConcurrentModificationException();
            }
            return true;
        }

        /**
         * Still has element to iterate
         *
         * @return true if there is still an element
         *         that has not been iterated over,
         *         false otherwise
         */
        @Override
        public boolean hasNext() {
            return (current != null);
        }

        /**
         * Next element in the iteration
         *
         * @return The next element in the iteration.
         *         The list is iterated from first to last
         *
         * @throws ConcurrentModificationException if the list
         *         has been modified during the iteration
         * @throws NoSuchElementException if there is no more
         *         element to iterate over
         */
        @Override
        public Item next() throws ConcurrentModificationException, NoSuchElementException {
            if (!hasNext()){
                throw new NoSuchElementException();
            }else{
                failFastCheck();
                Item result = this.current.getItem();
                this.current = this.current.getNext();
                return result;
            }
        }
    }

    /**
     * Return an iterator over the list
     *
     * @return An iterator that iterate from first to last
     */
    @Override
    public Iterator<Item> iterator() {
        return new CustomIterator();
    }

}
