import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class Evaluation implements Visitor {


    public Evaluation(){}

    @Override
    public int visit(Add visitable) {
        return this.operationLeft(visitable)+this.operationRight(visitable);
    }

    @Override
    public int visit(Mult visitable) {
        return this.operationLeft(visitable) * this.operationRight(visitable);
    }


    @Override
    public int visit(Div visitable) {
        int a = 0; int b = 0;
        a = this.operationLeft(visitable);
        b = this.operationRight(visitable);
        if (b != 0){
            return a/b;
        } else{
            throw new IllegalArgumentException();
        }

    }

    @Override
    public int visit(Sub visitable) {
        return this.operationLeft(visitable)-this.operationRight(visitable);
    }

    @Override
    public int visit(Leaf visitable) {
        return visitable.getValue();
    }

    public int operationLeft(Node visitable){
        if (visitable.getLeft() instanceof Add){
            return visit((Add) visitable.getLeft());
        }else if (visitable.getLeft() instanceof Mult){
            return visit((Mult) visitable.getLeft());
        }else if (visitable.getLeft() instanceof Sub){
            return visit((Sub) visitable.getLeft());
        }else if (visitable.getLeft() instanceof Div){
            return visit((Div) visitable.getLeft());
        }else{
            return visit((Leaf) visitable.getLeft());
        }
    }

    public int operationRight(Node visitable){
        if (visitable.getRight() instanceof Add){
            return visit((Add) visitable.getRight());
        }else if (visitable.getRight() instanceof Mult){
            return visit((Mult) visitable.getRight());
        }else if (visitable.getRight() instanceof Sub){
            return visit((Sub) visitable.getRight());
        }else if (visitable.getRight() instanceof Div){
            return visit((Div) visitable.getRight());
        }else{
            return visit((Leaf) visitable.getRight());
        }
    }
}
