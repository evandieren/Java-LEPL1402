import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Traversal {

    public static void recursiveInorder(Node root, List<Integer> res) {
        if (root == null){
            return;
        }
        recursiveInorder(root.left,res);
        res.add(root.val);
        recursiveInorder(root.right,res);
    }

    public static void iterativeInorder(Node root, List<Integer> res){
        Stack<Node> stack = new Stack<>();
        while (root != null || !stack.empty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }

    }

}
