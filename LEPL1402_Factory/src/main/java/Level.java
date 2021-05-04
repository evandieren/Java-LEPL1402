import java.util.ArrayList;
import java.util.Arrays;

public class Level extends AbstractLevel {

    /* Example of level building with this String : String s = "#-K\n-D-\n#-K\n"
     * Gives : LevelComponent[][] componentsObjects = {
     *                                        {new Wall(), new Floor(), new Key()},
     *                                        {new Floor(), new Door(), new Floor()},
     *                                        {new Wall(), new Floor(), new Key()}}
     */


    public Level(String input) {
        String[] split = input.split("\n");
        this.components = new LevelComponent[split.length][];
        for (int i = 0; i < this.components.length; i++) {
            LevelComponent[] row = new LevelComponent[split.length];
            for (int j = 0; j < row.length; j++) {
                row[j] = ElementFactory.getInstance().getElement(split[i].charAt(j));
            }
            this.components[i] = row;
        }
        this.size = split.length * split.length;
    }

    @Override
    public String toString() {
        String result = "";
        for (LevelComponent[] component : this.components) {
            for (LevelComponent levelComponent : component) {
                result += levelComponent.draw();
            }
            result += "\n";
        }
        return result;
    }

    @Override
    LevelComponent[][] getComponents() {
        return this.components;
    }

    @Override
    int getSize() {
        return this.size;
    }
}