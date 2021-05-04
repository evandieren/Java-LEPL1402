public class VisitableList extends Visitable{

    VisitableList(Object[] list){
        this.elements = list;
    }

    @Override
    void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
