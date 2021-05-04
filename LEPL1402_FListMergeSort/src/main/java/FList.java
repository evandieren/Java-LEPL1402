import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Predicate;

    public abstract class FList<A> implements Iterable<A> {

        public final boolean isNotEmpty() {
            return this instanceof Cons;
        }

        public final boolean isEmpty() {
            return this instanceof Nil;
        }

        public final int length() {
            FList<A> current = this;
            int result = 0;
            while (!(current instanceof FList.Nil)) {
                result += 1;
                current = current.tail();
            }
            return result;
        }

        public abstract A head();

        public abstract FList<A> tail();

        public static <A> FList<A> nil() {
            return (Nil<A>) Nil.INSTANCE;
        }

        public final FList<A> cons(final A a) {
            return new Cons(a, this);
        }

        public Iterator<A> iterator() {
            FList<A> current = this;

            return new Iterator<A>() {
                private FList<A> current = FList.this;

                public boolean hasNext() {
                    return current.isEmpty();
                }

                public A next() {
                    A result = current.head();
                    if (this.hasNext()) {
                        current = current.tail();
                        return result;
                    } else {
                        throw new NoSuchElementException();
                    }

                }

                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }

        public static final class Nil<A> extends FList<A> {
            private static final Nil<Object> INSTANCE = new Nil();

            @Override
            public A head() {
                throw new NoSuchElementException();
            }

            @Override
            public FList<A> tail() {
                throw new NoSuchElementException();
            }

        }

        public static final class Cons<A> extends FList<A> {

            private A head;
            private FList<A> tail;

            public Cons(A value, FList list) {
                this.head = value;
                this.tail = list;
            }

            @Override
            public A head() {
                return this.head;
            }

            @Override
            public FList<A> tail() {
                return this.tail;
            }

        }
    }

