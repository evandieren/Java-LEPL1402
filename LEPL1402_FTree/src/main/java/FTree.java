import java.util.function.Function;

public abstract class FTree<A> {

    public static int fTreeSum(FTree<Integer> ft){
        if(ft instanceof Node){
            return ft.value() + fTreeSum(ft.left()) + fTreeSum(ft.right());
        }
        return ft.value();
    }

    public static void main(String[] args) {
        FTree<Integer> root;
        FTree[] firstStage = new FTree[2];
        FTree[] secondStage = new FTree[4];
        FTree[] thirdStage = new FTree[8];
        FTree[] fleafs = new FTree[16];

        for(int i = 0 ; i < 16 ; i++){
            fleafs[i] = new Leaf(1+(2*i));
        }

        for(int i = 0; i<8 ; i++){
            thirdStage[i] = new Node<Integer>(2 + i*4, fleafs[i*2], fleafs[i*2+1]);
        }

        for(int i = 0 ; i <4 ; i++){
            secondStage[i] = new Node<Integer>(((i*8)+4), thirdStage[i*2], thirdStage[i*2+1]);
        }

        firstStage[0] = new Node<Integer>(8, secondStage[0], secondStage[1]);
        firstStage[1] = new Node<Integer>(24, secondStage[2], secondStage[3]);

        root = new Node<Integer>(16, firstStage[0], firstStage[1]);

        FTree<Integer> result = root.map(i -> i*10);

        System.out.println(root.value());
        System.out.println(result.value());
        System.out.println("--------------");
        System.out.println(root.left().value());
        System.out.println(result.left().value());
        System.out.println("--------------");
        System.out.println(root.left().left().value());
        System.out.println(result.left().left().value());
        System.out.println("--------------");
        System.out.println(root.left().left().left().value());
        System.out.println(result.left().left().left().value());
        System.out.println("--------------");
        System.out.println(root.left().left().left().left().value());
        System.out.println(result.left().left().left().left().value());

        int resultt = fTreeSum(result);

        System.out.println(resultt);
        
    }

    public final int depth() {
        if (this.left() == null){return 1;}
        return 1 + this.left().depth();
    }

    public abstract A value();
    public abstract FTree<A> left();
    public abstract FTree<A> right();


    public final <B> FTree<B> map(Function<A,B> f) {
        if (this.left() != null && this.right() != null){
            FTree result = new Node (f.apply(this.value()),this.left().map(f),this.right().map(f));
            return result;
        }else{
            return new Leaf (f.apply(this.value()));
        }
    }

}
