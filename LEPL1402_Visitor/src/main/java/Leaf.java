public class Leaf implements Visitable {

    private int value;

    Leaf(int value){
        this.value = value;
    }

    // YOUR CODE HERE

    public int getValue() {
        return this.value;
    }

    @Override
    public int accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
