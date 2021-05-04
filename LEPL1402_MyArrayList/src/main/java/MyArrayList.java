import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<Item> implements Iterable<Item> {

    private Object[] list;
    private int size;


    public MyArrayList(int initSize) {
        if (initSize < 0){
            throw new IndexOutOfBoundsException();
        }else{
            list = new Object[initSize];
            size = 0;
        }
    }


    /*
     * Checks if 'list' needs to be resized then add the element at the end
     * of the list.
     */
    public void enqueue(Item item) {
        if (size == list.length){
            Object [] oldList = list;
            list = new Object[2*list.length];
            if (oldList.length >= 0) System.arraycopy(oldList, 0, list, 0, oldList.length);
        }
        list[size++] = item;
    }


    /*
     * Removes the element at the specified position in this list.
     * Returns the element that was removed from the list. You dont need to
     * resize when removing an element.
     */
    public Item remove(int index) {
        Object result = null;
        if ((0 <= index) && (index < this.size)){
            result = list[index];
            for (int j = index; j < this.size - 1; j++) {
                list[j] = list[j+1];
            }
            list[size-1] = null;
            size--;
            return (Item) result;
        }else{
            throw new IndexOutOfBoundsException();
        }
    }


    public int size() {
        return this.size;
    }


    public Object[] getList() {
        return this.list;
    }

    @Override
    public Iterator<Item> iterator() {
        return new MyArrayListIterator();
    }


    private class MyArrayListIterator implements Iterator<Item> {
        private Object current = list[0];
        private int index = 0;
        private final int sizeInit = size;

        private boolean failFastCheck(){
            if (sizeInit != size){
                throw new ConcurrentModificationException();
            }
            return true;
        }


        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public Item next() {
            failFastCheck();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }else{
                Object result = current;
                if (index+1 < size){
                    current = list[index+1];
                    index ++;
                }else{
                    current = null;
                }
                return (Item) result;
            }
        }
    }
}