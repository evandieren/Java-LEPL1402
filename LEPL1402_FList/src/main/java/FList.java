import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Predicate;

abstract class FList<A> implements Iterable<A> {


    /**
     * Returns an empty FList
     */
    public static <A> FList<A> nil() {
        return (Nil<A>) Nil.INSTANCE;
    }

    /**
     * Returns a new FList obtained by prepending a to this list
     */
    public final FList<A> cons(final A a) {
        return new Cons(a, this);
    }

    /**
     * @return the number of elements in this list
     */
    public abstract int length();

    /**
     * @return true if the list is empty, false otherwise
     */
    public abstract boolean isEmpty();

    /**
     * @return the head of the list.
     * @throws NoSuchElementException if the list is empty
     */
    public abstract A head();

    /**
     * @return the tail of the list (i.e. the sublist without the first element of this list)
     * @throws NoSuchElementException if the list is empty
     */
    public abstract FList<A> tail();

    /**
     * Returns a new list containing the outputs obtained by applying function f to each element of this list
     */
    public abstract <B> FList<B> map(Function<A,B> f);

    /**
     * Returns a new list containing only the elements from this list that fullfill predicate f (i.e. f(elem) == true)
     */
    public abstract FList<A> filter(Predicate<A> f);


    public Iterator<A> iterator() {

        FList<A> current = this;

        return new Iterator<A>() {
            private FList<A> current = FList.this;
            public boolean hasNext() {
                return current.isEmpty();
            }

            public A next() {
                A result = current.head();
                if (this.hasNext()){
                    current = current.tail();
                    return result;
                }else{
                    throw new NoSuchElementException();
                }

            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }


    private static final class Nil<A> extends FList<A> {
        public static final Nil<Object> INSTANCE = new Nil();

        private Nil() { }

        @Override
        public int length() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return true;
        }

        @Override
        public A head() {
            throw new NoSuchElementException();
        }

        @Override
        public FList<A> tail() {
            throw new NoSuchElementException();
        }

        @Override
        public <B> FList<B> map(Function<A, B> f) {
            return new Nil<>();
        }

        @Override
        public FList<A> filter(Predicate<A> f) {
            return new Nil<>();
        }
    }

    private static final class Cons<A> extends FList<A> {

        private FList<A> next;
        private A value;

        public Cons(A value, FList list){
            this.value = value;
            this.next = list;
        }

        @Override
        public int length() {
            FList<A> current = this;
            int result = 0;
            while (!(current instanceof FList.Nil)){
                result += 1;
                current = current.tail();
            }
            return result;
        }

        @Override
        public boolean isEmpty() {
            return this.length() == 0;
        }

        @Override
        public A head() {
            return value;
        }

        @Override
        public FList<A> tail() {
            return this.next;
        }

        @Override
        public <B> FList<B> map(Function<A, B> f) {
            return new Cons(f.apply(this.value), this.tail().map(f));
        }

        @Override
        public FList<A> filter(Predicate<A> f) {
            if (f.test(this.value)){
                return new Cons(this.value , this.tail().filter(f));
            }
            return this.tail().filter(f);
        }
    }
}