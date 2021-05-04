public class Tree {

    public Node root;

    public Tree(Node root) {
        this.root = root;
    }

    @Override
    public boolean equals(Object o) {
        /**
         * 1) Pas un Tree
         * 2bis) root 1 == root 2 == null
         * 2) Root de 1 est null et l'autre non
         * 3) Inverse de 2
         * 3bis) L'un est une leaf et l'autre non
         * 3bisbis) Les deux sont leaf et sont égaux -> return equals les deux.
         * 4) Root.left n'existe pas mais o.left existe -> False
         * 5) Inverse de 4
         * 6) pareil que 4 pour le right
         * 7) Inverse de 6  ----> Tout ça est repris dans le equals à la ligne 36. (Déjà fait dans le node.equals)
         * 8) Si tout ça est ok, on crée deux trees pour recall sur le left avec root.left et o.left
         * 9) 8) avec les right
         */
        if (!(o instanceof Tree)){return false;} // 1

        Tree other = (Tree) o;

        if (this.root == null && other.root == null){return true;} // 2bis
        else if (this.root == null || other.root == null){return false;} // 2 - 3

        if (this.root.isLeaf() && other.root.isLeaf()){
            return this.root.equals(other.root);
        }else if (this.root.isLeaf() || other.root.isLeaf()){return false;}

        if (!(this.root.equals(other.root))){return false;}

        Tree treeLeft = new Tree(this.root.left);
        Tree treeLeftOther = new Tree(other.root.left);
        if (!(treeLeft.equals(treeLeftOther))){return false;}

        Tree treeRight = new Tree(this.root.right);
        Tree treeRightOther = new Tree(other.root.right);

        return treeRight.equals(treeRightOther);
    }

}