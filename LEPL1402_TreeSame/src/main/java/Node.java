public class Node {

    public int val;
    public Node left;
    public Node right;

    public Node(int val){

        this.val = val;
    }

    public boolean isLeaf(){

        return this.left == null && this.right == null;
    }

    @Override
    public boolean equals(Object o){
        if (!(o instanceof Node)){
            return false;
        }
        Node node = (Node) o;
        if (this.val != node.val){return false;}
        if (this.isLeaf()!= node.isLeaf()){return false;}
        if (this.left != null && !(this.left.equals(node.left))){return false;}
        if (this.left != null && !(this.right.equals(node.right))){return false;}
        return true;
    }


    /*
    public boolean equals(Object o) {
        boolean a = false;boolean b = false; boolean c = false;
        if(o instanceof Tree){
            Tree second = (Tree) o;
            if (this == null && second == null) {
                return true;
            } else if (this == null || second == null){
                return false;
            } else{
                if (this.root.val == second.root.val){
                    a = true;
                }
                if (this.root.left.equals(second.root.left)){
                    b = true;
                }
                if (this.root.right.equals(second.root.right)){
                    c = true;
                }
            }
            return a && b && c;
        }else{
            Node second = (Node) o;
            return this.equals(second);
        }
    }
     */
}