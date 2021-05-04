import java.util.List;

public class VisitorList extends Visitor {

    VisitorList(Class c){
        super(c);
    }

    @Override
    List<Object> getFiltered() {
        return this.filtered;
    }

    @Override
    void visit(Visitable visitable) {
        for (int i = 0; i < visitable.elements.length; i++) {
            this.visit(visitable.elements[i]);
        }
    }

    @Override
    void visit(Object o) {
        if (o.getClass() == this.toFilter){
            filtered.add(o);
        }
    }
}
