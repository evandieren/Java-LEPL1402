public class ElementFactory extends Factory {

    private static final ElementFactory currentElementFactory = new ElementFactory();

    private ElementFactory(){ }

    public static ElementFactory getInstance() {
        return currentElementFactory;
    }

    @Override
    public LevelComponent getElement(char c) {
        switch (c){
            case 'D':
                return new Door();
            case '-':
                return new Floor();
            case '#':
                return new Wall();
            case 'K':
                return new Key();
            default: throw new IllegalArgumentException();
        }
    }
}