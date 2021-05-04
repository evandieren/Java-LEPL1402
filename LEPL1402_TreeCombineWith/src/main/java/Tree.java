public class Tree {
    public Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public Tree combineWith(Tree o) {
        /**
         *
         * This - Tree o
         *
         * Tree3 : Arbre final
         * 4 arbres : Tree1.left Tree2.left Tree1.right Tree2.right
         *
         * Tree3.left = Tree1.left.combineWith(Tree2.left).root
         * Tree3.right = Tree1.right.combineWith(Tree2.right).root
         * return Tree3
         *
         * 1) o est null ou this est null -> On retourne l'un ou l'autre
         */

        if (o == null || o.root == null){return this;}
        if (this.root == null){return o;}

        Tree result = new Tree (this.root);
        result.root.val = this.root.val + o.root.val;

        Tree tree1 = new Tree(null);
        Tree tree2 = new Tree(null);
        Tree tree3 = new Tree(null);
        Tree tree4 = new Tree(null);

        if (this.root.left != null){
            tree1.root = this.root.left;
        }
        if (this.root.right != null){
            tree2.root = this.root.right;
        }
        if (o.root.left != null){
            tree3.root = o.root.left;
        }
        if (o.root.right != null){
            tree4.root = o.root.right;
        }

        result.root.left = tree1.combineWith(tree3).root;
        result.root.right = tree2.combineWith(tree4).root;
        return result;
    }
}